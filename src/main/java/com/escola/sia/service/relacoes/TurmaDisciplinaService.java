package com.escola.sia.service.relacoes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.escola.sia.model.relacoes.TurmaDisciplina;
import com.escola.sia.model.relacoes.chavesCompostas.TurmaDisciplinaId;
import com.escola.sia.repository.relacoes.TurmaDisciplinaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TurmaDisciplinaService {

    private final TurmaDisciplinaRepository turmaDisciplinaRepository;

    public TurmaDisciplinaService(TurmaDisciplinaRepository turmaDisciplinaRepository) {
        this.turmaDisciplinaRepository = turmaDisciplinaRepository;
    }

    public TurmaDisciplina salvarTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
        return turmaDisciplinaRepository.save(turmaDisciplina);
    }

    public List<TurmaDisciplina> listarTurmaDisciplina() {
        return turmaDisciplinaRepository.findAll();
    }

    public Optional<TurmaDisciplina> buscarTurmaDisciplinaPorId(TurmaDisciplinaId id) {
        return turmaDisciplinaRepository.findById(id);
    }

    /**
     * Busca uma relação turma-disciplina pelo seu ID composto.
     *
     * @param id ID composto da relação turma-disciplina a ser buscada
     * @return a relação turma-disciplina encontrada
     * @throws EntityNotFoundException caso a relação turma-disciplina não seja
     *                                 encontrada
     */
    public TurmaDisciplina getTurmaDisciplinaById(TurmaDisciplinaId id) {
        return turmaDisciplinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TurmaDisciplina não encontrada para o ID: " + id));
    }

    public void excluirTurmaDisciplina(TurmaDisciplinaId id) {
        turmaDisciplinaRepository.deleteById(id);
    }

    public Optional<TurmaDisciplina> atualizarTurmaDisciplina(TurmaDisciplinaId id,
            TurmaDisciplina turmaDisciplinaAtualizada) {
        return turmaDisciplinaRepository.findById(id).map(turmaDisciplinaExistente -> {
            turmaDisciplinaExistente.setIdTurma(turmaDisciplinaAtualizada.getIdTurma());
            turmaDisciplinaExistente.setIdDisciplina(turmaDisciplinaAtualizada.getIdDisciplina());
            return turmaDisciplinaRepository.save(turmaDisciplinaExistente);
        });
    }
}