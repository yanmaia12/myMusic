package com.yanmaia12.MyMusic.service;

import com.yanmaia12.MyMusic.model.Artista;
import com.yanmaia12.MyMusic.model.Musica;
import com.yanmaia12.MyMusic.records.AudioDbMusic;
import com.yanmaia12.MyMusic.records.MusicRecord;
import com.yanmaia12.MyMusic.repository.ArtistaRepo;
import com.yanmaia12.MyMusic.repository.MusicaRepo;
import com.yanmaia12.MyMusic.util.ConverteDados;
import com.yanmaia12.MyMusic.util.TratamentoErros;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    private final TheAudioDbService apiService;
    private final MusicaRepo musicaRepo;
    private final ArtistaService artistaService;
    private final ConverteDados converteDados;
    private final ArtistaRepo artistaRepo;

    public MusicaService (TheAudioDbService apiService, MusicaRepo musicaRepo, ArtistaService artistaService, ArtistaRepo  artistaRepo){
        this.apiService = apiService;
        this.musicaRepo = musicaRepo;
        this.artistaService = artistaService;
        this.artistaRepo = artistaRepo;
        this.converteDados = new ConverteDados();
    }

    public Musica getMusicaDados(){
        String nomeArtista = TratamentoErros.tratamentoString("Insira o nome do artista: ");
        String nomeMusica = TratamentoErros.tratamentoString("Insira o nome da música: ");

         Optional<Artista> artistaBanco = artistaRepo.findByNomeArtistaContainingIgnoreCase(nomeArtista);
        if (artistaBanco.isPresent()){
            var json = apiService.buscarMusica(nomeArtista, nomeMusica);
            AudioDbMusic audioDbMusic = converteDados.obterDados(json, AudioDbMusic.class);

            if (audioDbMusic != null && audioDbMusic.track() != null && !audioDbMusic.track().isEmpty()){
                MusicRecord musicRecord = audioDbMusic.track().get(0);
                return new Musica(musicRecord.nomeMusica(), musicRecord.nomeArtista(), musicRecord.nomeAlbum(), artistaBanco.get());
            }
            else{
                System.out.println("Música não encontrada ou nome está mal escrito, tente novamente!");
                return null;
            }
        }else {
            System.out.println("Para adicionar a música tem que adicionar o artista primeiro!");
            return null;
        }
    }

    @Transactional
    public void adicionarMusica(){
        Musica musica = getMusicaDados();
        if (musica != null){
            Optional<Musica> musicaAchada = musicaRepo.findByNomeMusica(musica.getNomeMusica());
            if (musicaAchada.isPresent()){
                System.out.println("Música já adicionada anteriormente!");
                return;
            }
            Artista artistaDaMsc = musica.getArtista();
            artistaDaMsc.adicionarMusica(musica);
            musicaRepo.save(musica);
            System.out.println("Música adicionada com sucesso!");
        }
    }

    public void apagarMusica(){
        Musica musica = getMusicaDados();
        String res = TratamentoErros.tratamentoString("Pretende apagar %s de %s? (s/n) ".formatted(musica.getNomeMusica(), musica.getNomeArtista()));
        if (res.equalsIgnoreCase("s")){
            musicaRepo.deleteById(musica.getId());
            System.out.println("Música apagada com sucesso!");
        }
    }

    public void listarTodasMusicas(){
        List<Musica> listaMusica = musicaRepo.findAll();
        listaMusica.forEach(m -> System.out.println("%s - %s".formatted(m.getNomeMusica(), m.getNomeArtista())));
    }
}
