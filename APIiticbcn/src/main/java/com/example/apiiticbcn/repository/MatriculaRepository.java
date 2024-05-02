package com.example.apiiticbcn.repository;

import com.example.apiiticbcn.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}