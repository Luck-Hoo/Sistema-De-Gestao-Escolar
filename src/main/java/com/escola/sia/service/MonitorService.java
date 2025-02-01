package com.escola.sia.service;

import com.escola.sia.model.Monitor;
import com.escola.sia.repository.MonitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    // Método para salvar um monitor
    public Monitor salvarMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    // Método para buscar todos os monitores
    public List<Monitor> listarMonitores() {
        return monitorRepository.findAll();
    }

    // Método para buscar um monitor por ID
    public Optional<Monitor> buscarMonitorPorId(int id_monitor) {
        return monitorRepository.findById(id_monitor);
    }

    public Monitor atualizarMonitor(int id, Monitor monitorAtualizado) {
        Monitor monitorExistente = monitorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Monitor não encontrado: " + id));

        monitorExistente.setNome(monitorAtualizado.getNome());
        monitorExistente.setEmail(monitorAtualizado.getEmail());
        monitorExistente.setTelefone(monitorAtualizado.getTelefone());

        return monitorRepository.save(monitorExistente);
    }

    // Método para excluir um monitor por ID
    public void excluirMonitor(int id_monitor) {
        monitorRepository.deleteById(id_monitor);
    }
}
