package com.yanmaia12.MyMusic.repository;

import com.yanmaia12.MyMusic.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepo extends JpaRepository<Long, Musica> {
}
