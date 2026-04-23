package com.yanmaia12.MyMusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "musicas")
@Getter
@Setter
public class Musica {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nomeMusica", unique = true, nullable = false)
    private String nomeMusica;

    @Column(name = "nomeArtista", unique = true, nullable = false)
    private String nomeArtista;

    @Column(name = "nomeAlbum", unique = true, nullable = false)
    private String nomeAlbum;

    @ManyToOne()
    private Artista artista;


    public Musica() {
    }

    public Musica(String nomeMusica, String nomeArtista, String nomeAlbum, Artista artista) {
        this.nomeMusica = nomeMusica;
        this.nomeArtista = nomeArtista;
        this.nomeAlbum = nomeAlbum;
        this.artista = artista;
    }
}
