package com.yanmaia12.MyMusic.service;

import com.yanmaia12.MyMusic.model.Artista;
import com.yanmaia12.MyMusic.records.ArtistRecord;
import com.yanmaia12.MyMusic.records.AudioDbArtist;
import com.yanmaia12.MyMusic.repository.ArtistaRepo;
import com.yanmaia12.MyMusic.util.ConverteDados;
import com.yanmaia12.MyMusic.util.TratamentoErros;
import org.apache.catalina.webresources.AbstractArchiveResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private TheAudioDbService apiService;
    @Autowired
    private ArtistaRepo artistaRepo;

    private ConverteDados converteDados = new ConverteDados();

    public Artista getDadosArtista(){
        String nomeArtista = TratamentoErros.tratamentoString("Insira o nome do artista que pretende buscar: ");
        var json = apiService.buscarArtista(nomeArtista.replace(" ", "_"));
        AudioDbArtist audioDbArtist = converteDados.obterDados(json, AudioDbArtist.class);

        if (audioDbArtist != null && !audioDbArtist.artists().isEmpty()){
            ArtistRecord artistRecord = audioDbArtist.artists().get(0);
            return new Artista(artistRecord.nomeArtista(), artistRecord.genero());
        }else{
            System.out.println("Artista não encontrado na API!");
            return null;
        }
    }

    public void adicionarArtista(){
        Artista artista = getDadosArtista();
        if (artista != null){
            System.out.println("%s - gênero musical: %s".formatted(artista.getNomeArtista(), artista.getGenero()));
            artistaRepo.save(artista);
        }
    }

    public void apagarArtista(){
        String nomeArtista = TratamentoErros.tratamentoString("Insira o nome do artista: ");
        Optional<Artista> artista = artistaRepo.findByNomeArtistaContainingIgnoreCase(nomeArtista);
        if (!artista.isEmpty()){
            Artista artistaBuscado = artista.get();
            System.out.println("%s - gênero musical: %s".formatted(artistaBuscado.getNomeArtista(), artistaBuscado.getGenero()));
            String resposta = TratamentoErros.tratamentoString("Deseja apagar esse artista da lista (s/n)? ");
            if (resposta.equalsIgnoreCase("s")){
                artistaRepo.delete(artistaBuscado);
                System.out.println("Artista apagado com sucesso!");
            }else{
                System.out.println("Operação Cancelada!");
            }
        }else {
            System.out.println("Artista não encontrado!");
        }

    }
}
