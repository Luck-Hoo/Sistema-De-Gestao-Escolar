package com.escola.sia.service.relacoes;

import com.escola.sia.model.relacoes.ProfessorDisciplina;
import com.escola.sia.model.relacoes.chavesCompostas.ProfessorDisciplinaId;
import com.escola.sia.repository.relacoes.ProfessorDisciplinaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorDisciplinaService {

    private final ProfessorDisciplinaRepository professorDisciplinaRepository;

    public ProfessorDisciplinaService(ProfessorDisciplinaRepository professorDisciplinaRepository) {
        this.professorDisciplinaRepository = professorDisciplinaRepository;
    }

    // Método para salvar uma nova relação professor-disciplina
    public ProfessorDisciplina salvarRelacao(ProfessorDisciplina professorDisciplina) {
        return professorDisciplinaRepository.save(professorDisciplina);
    }

    // Método para buscar todas as relações professor-disciplina
    public List<ProfessorDisciplina> listarRelacoes() {
        return professorDisciplinaRepository.findAll();
    }

    // Método para buscar uma relação professor-disciplina pelo ID composto
    public Optional<ProfessorDisciplina> buscarRelacaoPorId(ProfessorDisciplinaId id) {
        return professorDisciplinaRepository.findById(id);
    }

    // Método para buscar relações professor-disciplina por matricula do professor
    public List<ProfessorDisciplina> buscarRelacoesPorProfessor(String matriculaProfessor) {
        return professorDisciplinaRepository.findByMatriculaProfessor(matriculaProfessor);
    }

    // Método para buscar relações professor-disciplina por id da disciplina
    public List<ProfessorDisciplina> buscarRelacoesPorDisciplina(Integer disciplinaId) {
        return professorDisciplinaRepository.findByIdDisciplina(disciplinaId);
    }

    // Método para excluir uma relação professor-disciplina pelo ID composto
    public void excluirRelacaoPorId(ProfessorDisciplinaId id) {
        professorDisciplinaRepository.deleteById(id);
    }

    // Método para excluir todas as relações de um professor
    public void excluirRelacoesPorProfessor(String matriculaProfessor) {
        professorDisciplinaRepository.deleteByMatriculaProfessor(matriculaProfessor);
    }

    // Método para excluir todas as relações de uma disciplina
    public void excluirRelacoesPorDisciplina(Integer disciplinaId) {
        professorDisciplinaRepository.deleteByIdDisciplina(disciplinaId);
    }

    // Método para atualizar uma relação professor-disciplina
    @Transactional
    public ProfessorDisciplina atualizarRelacao(ProfessorDisciplinaId id,
            ProfessorDisciplina professorDisciplinaAtualizado) {
        Optional<ProfessorDisciplina> professorDisciplinaExistente = professorDisciplinaRepository.findById(id);

        if (professorDisciplinaExistente.isPresent()) {
            ProfessorDisciplina professorDisciplina = professorDisciplinaExistente.get();
            professorDisciplina.setProfessor(professorDisciplinaAtualizado.getProfessor());
            professorDisciplina.setDisciplina(professorDisciplinaAtualizado.getDisciplina());
            return professorDisciplinaRepository.save(professorDisciplina);
        } else {
            throw new IllegalArgumentException("Relacao professor disciplina com ID " + id + " não encontrada.");
        }

    }
}
