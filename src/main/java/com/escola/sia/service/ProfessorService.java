package com.escola.sia.service;

import com.escola.sia.model.Professor;
import com.escola.sia.repository.ProfessorRepository;
import com.escola.sia.repository.relacoes.HorarioAulaRepository;
import com.escola.sia.repository.relacoes.ProfessorDisciplinaRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorDisciplinaRepository professorDisciplinaRepository;
    private final HorarioAulaRepository horarioAulaRepository;

    public ProfessorService(ProfessorRepository professorRepository,
            ProfessorDisciplinaRepository professorDisciplinaRepository, HorarioAulaRepository horarioAulaRepository) {
        this.professorRepository = professorRepository;
        this.professorDisciplinaRepository = professorDisciplinaRepository;
        this.horarioAulaRepository = horarioAulaRepository;

    }

    // Método para salvar um professor
    public Professor salvarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    // Método para buscar todos os professores
    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    // Método para buscar um professor por ID
    public Optional<Professor> buscarProfessorPorId(String idProfessor) {
        return professorRepository.findById(idProfessor);
    }

    // Método para excluir um professor por ID
    @Transactional
    public void excluirProfessor(String idProfessor) {
        professorRepository.deleteById(idProfessor);
    }

    @Transactional
    public Professor atualizarProfessor(String idProfessor, Professor professorAtualizado) {
        Optional<Professor> professorExistente = professorRepository.findById(idProfessor);

        if (professorExistente.isPresent()) {

            verificarEmailUnico(professorAtualizado.getEmail(), idProfessor);

            // Excluir o professor antigo
            excluirProfessor(idProfessor);

            return salvarProfessor(professorAtualizado);

        } else {
            throw new IllegalArgumentException("Professor com ID " + idProfessor + " não encontrado.");
        }
    }

    private void verificarEmailUnico(String email, String idProfessor) {
        Optional<Professor> professorExistente = professorRepository.findByEmail(email);
        if (professorExistente.isPresent()) {
            if (idProfessor == null || !professorExistente.get().getIdProfessor().equals(idProfessor)) {
                throw new IllegalArgumentException("Já existe um professor cadastrado com o email: " + email);
            }
        }
    }

}
