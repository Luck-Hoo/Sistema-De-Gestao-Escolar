package com.escola.sia.service;

import com.escola.sia.repository.DisciplinaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.escola.sia.model.Disciplina;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina salvarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarDisciplinaPorId(int Id) {
        return disciplinaRepository.findById(Id);
    }

    public void excluirDisciplina(int Id) {
        disciplinaRepository.deleteById(Id);
    }
}
