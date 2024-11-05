package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
}
