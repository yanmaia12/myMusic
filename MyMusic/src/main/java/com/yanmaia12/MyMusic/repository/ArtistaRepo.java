package com.yanmaia12.MyMusic.repository;

import com.yanmaia12.MyMusic.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepo  extends JpaRepository<Artista, Long>{

    Optional<Artista> findByNomeArtistaContainingIgnoreCase(String nome);
}
