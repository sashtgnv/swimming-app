package com.example.swimming_championships_app;

import com.example.swimming_championships_app.ui.MainStage;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//главный класс приложения spring boot
@SpringBootApplication
public class SwimmingChampionshipsApplication {
    public static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(SwimmingChampionshipsApplication.class, args);
        Application.launch(MainStage.class, args);
    }
}
