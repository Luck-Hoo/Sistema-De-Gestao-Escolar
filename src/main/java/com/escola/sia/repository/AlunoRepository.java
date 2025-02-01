package com.escola.sia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.sia.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {

}
