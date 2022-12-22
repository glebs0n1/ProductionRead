package com.example.demo.repository;

import com.example.demo.model.TextWordModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextWordRepository extends JpaRepository< TextWordModel, Long> {
    List< TextWordModel > findByTextWordContaining(String textWord);
}