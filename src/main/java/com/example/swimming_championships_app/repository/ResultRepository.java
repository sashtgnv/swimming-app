package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Integer> {
}
