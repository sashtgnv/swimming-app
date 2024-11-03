package com.example.swimming_championships_app;

import com.example.swimming_championships_app.ui.MainStage;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwimmingChampionshipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwimmingChampionshipsApplication.class, args);
		Application.launch(MainStage.class,args);
	}
}
