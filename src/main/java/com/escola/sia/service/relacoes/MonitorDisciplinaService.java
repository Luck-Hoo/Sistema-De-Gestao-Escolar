package com.escola.sia.service.relacoes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.escola.sia.model.relacoes.MonitorDisciplina;
import com.escola.sia.model.relacoes.chavesCompostas.MonitorDisciplinaId;
import com.escola.sia.repository.relacoes.MonitorDisciplinaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MonitorDisciplinaService {

    private final MonitorDisciplinaRepository monitorDisciplinaRepository;

    public MonitorDisciplinaService(MonitorDisciplinaRepository monitorDisciplinaRepository) {
        this.monitorDisciplinaRepository = monitorDisciplinaRepository;
    }

    public MonitorDisciplina salvarMonitorDisciplina(MonitorDisciplina monitorDisciplina) {
        return monitorDisciplinaRepository.save(monitorDisciplina);
    }

    public List<MonitorDisciplina> listarMonitorDisciplina() {
        return monitorDisciplinaRepository.findAll();
    }

    public Optional<MonitorDisciplina> buscarMonitorDisciplinaPorId(MonitorDisciplinaId id) {
        return monitorDisciplinaRepository.findById(id);
    }

    /**
     * Busca uma relação monitor-disciplina pelo seu ID composto.
     *
     * @param id ID composto da relação monitor-disciplina a ser buscada
     * @return a relação monitor-disciplina encontrada
     * @throws EntityNotFoundException caso a relação monitor-disciplina não seja
     *                                 encontrada
     */
    public MonitorDisciplina getMonitorDisciplinaById(MonitorDisciplinaId id) {
        return monitorDisciplinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MonitorDisciplina não encontrada para o ID: " + id));
    }

    public void excluirMonitorDisciplina(MonitorDisciplinaId id) {
        monitorDisciplinaRepository.deleteById(id);
    }

    public Optional<MonitorDisciplina> atualizarMonitorDisciplina(MonitorDisciplinaId id,
            MonitorDisciplina monitorDisciplinaAtualizado) {
        return monitorDisciplinaRepository.findById(id).map(monitorDisciplinaExistente -> {
            monitorDisciplinaExistente.setMonitor(monitorDisciplinaAtualizado.getMonitor());
            monitorDisciplinaExistente.setDisciplina(monitorDisciplinaAtualizado.getDisciplina());
            return monitorDisciplinaRepository.save(monitorDisciplinaExistente);
        });
    }
}