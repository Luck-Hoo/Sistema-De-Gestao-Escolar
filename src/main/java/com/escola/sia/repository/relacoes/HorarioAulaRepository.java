package com.escola.sia.repository.relacoes;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escola.sia.model.relacoes.HorarioAula;
import com.escola.sia.model.relacoes.HorarioAula.DiaSemana;

public interface HorarioAulaRepository extends JpaRepository<HorarioAula, Integer> {
        List<HorarioAula> findByProfessor_IdProfessorAndTurma_IdTurmaAndDisciplina_IdDisciplina(
                        String id_professor,
                        int id_turma, int id_disciplina);

        List<HorarioAula> findByDiaSemanaAndHorario(DiaSemana diaSemana, LocalTime horario);

        @Query("SELECT h FROM HorarioAula h ORDER BY CASE WHEN :orderBy = 'professor' THEN h.professor.nome " +
                        "WHEN :orderBy = 'turma' THEN h.turma.nomeTurma " +
                        "WHEN :orderBy = 'disciplina' THEN h.disciplina.nome " +
                        "WHEN :orderBy = 'diaSemana' THEN h.diaSemana " +
                        "WHEN :orderBy = 'horario' THEN h.horario " +
                        "END")
        List<HorarioAula> findAllOrderBy(@Param("orderBy") String orderBy);

}
