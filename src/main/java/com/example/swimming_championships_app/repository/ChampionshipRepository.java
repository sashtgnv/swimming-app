package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Championship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ChampionshipRepository extends JpaRepository<Championship,Integer> {

    List<Championship> findByDateLessThanEqualOrderByDateDesc(Date date);
}
