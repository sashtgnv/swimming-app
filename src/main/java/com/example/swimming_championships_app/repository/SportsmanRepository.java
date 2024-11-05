package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsmanRepository extends JpaRepository<Sportsman,Integer> {
}
