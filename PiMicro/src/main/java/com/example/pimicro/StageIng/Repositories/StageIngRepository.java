package com.example.pimicro.StageIng.Repositories;

import com.example.pimicro.StageIng.Class.StageIng;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StageIngRepository extends JpaRepository<StageIng, Long> {
    List<StageIng> findByValide(boolean valide); // Fetch validated/unvalidated internships
}
