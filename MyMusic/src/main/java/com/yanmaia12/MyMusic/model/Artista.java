package com.yanmaia12.MyMusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Lombok;
import lombok.Setter;

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
}
