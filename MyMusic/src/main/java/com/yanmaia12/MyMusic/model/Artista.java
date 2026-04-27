package com.yanmaia12.MyMusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
@Getter
@Setter
public class Artista {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nomeArtista", nullable = false)
    private String nomeArtista;

    @Column(name = "genero")
    private String genero;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Musica> listaMusicas;

    public Artista() {
    }

    public Artista(String nomeArtista, String genero) {
        this.nomeArtista = nomeArtista;
        this.genero = genero;
    }

    public void setListaMusicas(List<Musica> listaMusicas) {
        this.listaMusicas = listaMusicas;
        if (!listaMusicas.isEmpty()){
            listaMusicas.forEach(m -> m.setArtista(this));
        }
    }

    public void adicionarMusica(Musica musica){
        if (this.listaMusicas.isEmpty()){
            this.listaMusicas = new ArrayList<>();
        }
        musica.setArtista(this);
        this.listaMusicas.add(musica);
    }
}
