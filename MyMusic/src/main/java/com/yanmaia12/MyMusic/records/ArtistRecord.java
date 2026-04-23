package com.yanmaia12.MyMusic.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistRecord(
    @JsonAlias("strArtist") String nomeArtista,
    @JsonAlias("strGenre") String genero){
}
