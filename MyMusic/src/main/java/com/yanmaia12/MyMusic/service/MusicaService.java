package com.yanmaia12.MyMusic.service;

import com.yanmaia12.MyMusic.model.Musica;
import com.yanmaia12.MyMusic.records.AudioDbMusic;
import com.yanmaia12.MyMusic.records.MusicRecord;
import com.yanmaia12.MyMusic.repository.MusicaRepo;
import com.yanmaia12.MyMusic.util.ConverteDados;
import com.yanmaia12.MyMusic.util.TratamentoErros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {
    @Autowired
    private TheAudioDbService apiService;
    @Autowired
    private MusicaRepo musicaRepo;

    private ConverteDados converteDados = new ConverteDados();

    public Musica getMusicaDados(){
        String nomeArtista = TratamentoErros.tratamentoString("Insira o nome do artista que pretende buscar: ");
        String nomeMusica = TratamentoErros.tratamentoString("Insira o nome da música: ");
        var json = apiService.buscarMusica(nomeArtista, nomeMusica);
        AudioDbMusic audioDbMusic = converteDados.obterDados(json, AudioDbMusic.class);

        if (audioDbMusic != null && !audioDbMusic.track().isEmpty()){
            MusicRecord musicRecord = audioDbMusic.track().get(0);
            return new Musica(musicRecord.nomeMusica(), musicRecord.nomeArtista(), musicRecord.nomeAlbum(), musicRecord.)
        }
    }
}
