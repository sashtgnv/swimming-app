package com.example.swimming_championships_app;

import com.example.swimming_championships_app.service.impl.ChampionshipServiceImpl;
import com.example.swimming_championships_app.service.impl.RequestServiceImpl;
import com.example.swimming_championships_app.ui.MainStage;
import com.example.swimming_championships_app.util.Time;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class SwimmingChampionshipsApplication {

	static ChampionshipServiceImpl championshipService;
	static RequestServiceImpl requestService;

	public SwimmingChampionshipsApplication(ChampionshipServiceImpl championshipService,
											RequestServiceImpl requestService) {
		SwimmingChampionshipsApplication.championshipService = championshipService;
		SwimmingChampionshipsApplication.requestService = requestService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SwimmingChampionshipsApplication.class, args);
		Application.launch(MainStage.class,args);
	}
}
