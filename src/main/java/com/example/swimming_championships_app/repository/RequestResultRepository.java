package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.RequestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestResultRepository extends JpaRepository<RequestResult,Integer> {
}
