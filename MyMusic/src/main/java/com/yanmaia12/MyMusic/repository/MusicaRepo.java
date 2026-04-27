package com.yanmaia12.MyMusic.repository;

import com.yanmaia12.MyMusic.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicaRepo extends JpaRepository<Musica, Long> {
    Optional<Musica> findByNomeMusica(String nome);
}
