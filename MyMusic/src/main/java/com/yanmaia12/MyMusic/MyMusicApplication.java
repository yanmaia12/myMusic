package com.yanmaia12.MyMusic;

import com.yanmaia12.MyMusic.service.TheAudioDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyMusicApplication implements CommandLineRunner {

	@Autowired
	private TheAudioDbService theAudioDbService;

	public static void main(String[] args) {
		SpringApplication.run(MyMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(theAudioDbService.buscarMusica("drake", "Passionfruit"));
	}
}
