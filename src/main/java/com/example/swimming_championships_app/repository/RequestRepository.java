package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer> {
}
