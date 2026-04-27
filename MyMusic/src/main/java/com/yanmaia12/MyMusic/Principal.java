package com.yanmaia12.MyMusic;

import com.yanmaia12.MyMusic.service.ArtistaService;
import com.yanmaia12.MyMusic.service.MusicaService;
import com.yanmaia12.MyMusic.util.TratamentoErros;
import org.springframework.stereotype.Component;

@Component
public class Principal {
    private final ArtistaService artistaService;
    private final MusicaService musicaService;

    public Principal(ArtistaService artistaService, MusicaService musicaService){
        this.artistaService = artistaService;
        this.musicaService = musicaService;
    }

    public void exibeMenu(){
        int res = 666;
        while (res != 0){
            System.out.println("""
                1 - Adicionar artista
                2 - Apagar artista
                3 - Adicionar música
                4 - Apagar música
                
                0 - sair
                """);
            res = TratamentoErros.tratamentoInteiros("Escolha um número: ");

            switch (res){
                case 1:
                    artistaService.adicionarArtista();
                    break;
                case 2:
                    artistaService.apagarArtista();
                    break;
                case 3:
                    musicaService.adicionarMusica();
                    break;
                case 4:
                    musicaService.apagarMusica();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }
}
