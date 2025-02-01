package com.escola.sia.service;

import com.escola.sia.model.Turma;
import com.escola.sia.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    // Método para salvar uma turma
    public Turma salvarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    // Método para buscar todas as turmas
    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    // Método para buscar uma turma por ID
    public Optional<Turma> buscarTurmaPorId(int id_turma) {
        return turmaRepository.findById(id_turma);
    }

    // Método para excluir uma turma por ID
    public void excluirTurma(int id_turma) {
        turmaRepository.deleteById(id_turma);
    }

    // Atualizar turma
    public Turma atualizarTurma(int id, Turma turmaAtualizada) {
        Optional<Turma> turmaExistente = turmaRepository.findById(id);

        if (turmaExistente.isPresent()) {
            Turma turma = turmaExistente.get();

            // Atualizando os campos da turma
            turma.setNomeTurma(turmaAtualizada.getNomeTurma());

            // Salvando a turma atualizada
            return turmaRepository.save(turma);
        } else {
            throw new RuntimeException("Turma não encontrada com o ID: " + id);
        }
    }
}
