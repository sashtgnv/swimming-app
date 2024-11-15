package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Championship;

import java.util.Date;
import java.util.List;

public interface ChampionshipService extends Service<Championship> {

    List<Championship> findEarlyThan(Date date);

}
