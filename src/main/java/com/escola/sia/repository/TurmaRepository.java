package com.escola.sia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.sia.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
