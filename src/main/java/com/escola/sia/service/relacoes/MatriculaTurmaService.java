package com.escola.sia.service.relacoes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.escola.sia.model.relacoes.MatriculaTurma;
import com.escola.sia.repository.relacoes.MatriculaTurmaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MatriculaTurmaService {
    private final MatriculaTurmaRepository matriculaTurmaRepository;

    public MatriculaTurmaService(MatriculaTurmaRepository matriculaTurmaRepository) {
        this.matriculaTurmaRepository = matriculaTurmaRepository;
    }

    public MatriculaTurma salvarMatriculaTurma(MatriculaTurma matriculaTurma) {
        return matriculaTurmaRepository.save(matriculaTurma);
    }

    public List<MatriculaTurma> listarMatriculaTurma() {
        return matriculaTurmaRepository.findAll();
    }

    public Optional<MatriculaTurma> buscarMatriculaTurmaPorId(int id) {
        return matriculaTurmaRepository.findById(id);
    }

    /**
     * Busca uma matricula de turma pelo seu ID.
     * 
     * @param id ID da matricula de turma a ser buscada
     * @return a matricula de turma encontrada
     * @throws EntityNotFoundException caso a matricula de turma não seja encontrada
     */
    public MatriculaTurma getMatriculaTurmaById(int id) {
        return matriculaTurmaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MatriculaTurma não encontrada para o ID: " + id));
    }

    public void excluirMatriculaTurma(int id) {
        matriculaTurmaRepository.deleteById(id);
    }

    public Optional<MatriculaTurma> atualizarMatriculaTurma(int id, MatriculaTurma matriculaTurmaAtualizada) {
        return matriculaTurmaRepository.findById(id).map(matriculaTurmaExistente -> {
            matriculaTurmaExistente.setMatriculaAluno(matriculaTurmaAtualizada.getMatriculaAluno());
            matriculaTurmaExistente.setIdTurma(matriculaTurmaAtualizada.getIdTurma());
            matriculaTurmaExistente.setDataMatricula(matriculaTurmaAtualizada.getDataMatricula());
            return matriculaTurmaRepository.save(matriculaTurmaExistente);
        });
    }
}