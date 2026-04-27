package com.yanmaia12.MyMusic;

import com.yanmaia12.MyMusic.service.ArtistaService;
import com.yanmaia12.MyMusic.service.TheAudioDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyMusicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyMusicApplication.class, args);
	}

	@Autowired
	private Principal principal;

	@Override
	public void run(String... args) throws Exception {
		principal.exibeMenu();
	}
}
