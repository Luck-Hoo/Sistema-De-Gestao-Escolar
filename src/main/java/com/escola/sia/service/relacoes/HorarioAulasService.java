package com.escola.sia.service.relacoes;

import com.escola.sia.model.relacoes.HorarioAula;
import com.escola.sia.model.relacoes.HorarioAula.DiaSemana;
import com.escola.sia.repository.relacoes.HorarioAulaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioAulasService {
    private HorarioAulaRepository horarioAulaRepository;

    public HorarioAulasService(HorarioAulaRepository horarioAulaRepository) {
        this.horarioAulaRepository = horarioAulaRepository;
    }

    // Criar ou atualizar um HorarioAula
    @Transactional
    public HorarioAula salvarHorarioAula(HorarioAula horarioAula) {
        return horarioAulaRepository.save(horarioAula);
    }

    // Encontrar um HorarioAula por ID
    public Optional<HorarioAula> encontrarHorarioAulaPorId(Integer id) {
        return horarioAulaRepository.findById(id);
    }

    // Buscar todos os Horarios de Aula
    public List<HorarioAula> listarTodosHorariosAula() {
        return horarioAulaRepository.findAll();
    }

    // Deletar um HorarioAula por ID
    @Transactional
    public void deletarHorarioAula(Integer id) {
        horarioAulaRepository.deleteById(id);
    }

    // Buscar Horarios de Aula por professor, turma e disciplina
    public List<HorarioAula> buscarHorariosPorProfessorTurmaEDisciplina(
            String id_professor,
            int id_turma,
            int id_disciplina) {
        return horarioAulaRepository.findByProfessor_IdProfessorAndTurma_IdTurmaAndDisciplina_IdDisciplina(
                id_professor,
                id_turma, id_disciplina);
    }

    // Buscar Horarios de Aula por dia da semana e horário
    public List<HorarioAula> buscarHorariosPorDiaSemanaEHorario(DiaSemana diaSemana, LocalTime horario) {
        return horarioAulaRepository.findByDiaSemanaAndHorario(diaSemana, horario);
    }

    public List<HorarioAula> listarHorariosOrdenados(String orderBy) {
        if (orderBy == null || orderBy.isEmpty()) {
            return horarioAulaRepository.findAll();
        }
        return horarioAulaRepository.findAllOrderBy(orderBy);
    }
}
