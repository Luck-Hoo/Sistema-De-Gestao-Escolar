package com.escola.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.sia.model.Aluno;
import com.escola.sia.model.NotaAluno;

@Repository
public interface NotaAlunoRepository extends JpaRepository<NotaAluno, Integer> {
    List<NotaAluno> findByAluno(Aluno aluno);

}