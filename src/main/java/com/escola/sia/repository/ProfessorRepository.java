package com.escola.sia.repository;

import com.escola.sia.model.Professor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
    Optional<Professor> findByEmail(String email);
}
