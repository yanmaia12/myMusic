package com.yanmaia12.MyMusic.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MusicRecord(
                          @JsonAlias("strTrack") String nomeMusica,
                          @JsonAlias("strArtist") String nomeArtista,
                          @JsonAlias("strAlbum") String nomeAlbum) {
}
