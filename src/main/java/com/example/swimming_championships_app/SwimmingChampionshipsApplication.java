package com.example.swimming_championships_app;

import com.example.swimming_championships_app.model.*;
import com.example.swimming_championships_app.service.impl.*;
import com.example.swimming_championships_app.ui.MainStage;
import com.example.swimming_championships_app.util.Time;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SwimmingChampionshipsApplication {
	public static ApplicationContext context;
	static ChampionshipServiceImpl championshipService;
	static DisciplineServiceImpl disciplineService;
	static TrainerServiceImpl trainerService;
	static RequestServiceImpl requestService;
	static ResultServiceImpl resultService;

	@Autowired
	public void setResultService(ResultServiceImpl resultService) {
		SwimmingChampionshipsApplication.resultService = resultService;
	}

	@Autowired
	public void setRequestService(RequestServiceImpl requestService) {
		SwimmingChampionshipsApplication.requestService = requestService;
	}

	@Autowired
	public void setTrainerService(TrainerServiceImpl trainerService) {
		this.trainerService = trainerService;
	}

	static SportsmanServiceImpl sportsmanService;
	@Autowired
	public void setSportsmanService(SportsmanServiceImpl sportsmanService) {
		SwimmingChampionshipsApplication.sportsmanService = sportsmanService;
	}

	@Autowired
	public void setChampionshipService(ChampionshipServiceImpl championshipService) {
		SwimmingChampionshipsApplication.championshipService = championshipService;
	}

	@Autowired
	public void setDisciplineService(DisciplineServiceImpl disciplineService) {
		SwimmingChampionshipsApplication.disciplineService = disciplineService;
	}

	public static void main(String[] args) {
		context = SpringApplication.run(SwimmingChampionshipsApplication.class, args);
		Application.launch(MainStage.class,args);
		Random r = new Random();
		var requests = requestService.findAll();

//		System.out.println(new Time("04:00.00").getAll());
	}
}
