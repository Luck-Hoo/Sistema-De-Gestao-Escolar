package com.escola.sia.repository.relacoes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escola.sia.model.relacoes.ProfessorDisciplina;
import com.escola.sia.model.relacoes.chavesCompostas.ProfessorDisciplinaId;

import jakarta.transaction.Transactional;

@Repository
public interface ProfessorDisciplinaRepository extends JpaRepository<ProfessorDisciplina, ProfessorDisciplinaId> {
    List<ProfessorDisciplina> findByMatriculaProfessor(String matriculaProfessor);

    List<ProfessorDisciplina> findByIdDisciplina(Integer idDisciplina);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProfessorDisciplina pd WHERE pd.matriculaProfessor = :matriculaProfessor")
    void deleteByMatriculaProfessor(@Param("matriculaProfessor") String matriculaProfessor);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProfessorDisciplina pd WHERE pd.idDisciplina = :idDisciplina")
    void deleteByIdDisciplina(@Param("idDisciplina") Integer idDisciplina);
}
