package com.escola.sia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.escola.sia.model.Aluno;
import com.escola.sia.repository.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Método para salvar um aluno
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Método para buscar todos os alunos
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    // Método para buscar um aluno por matrícula
    public Optional<Aluno> buscarAlunoPorMatricula(String matricula) {
        return alunoRepository.findById(matricula);
    }

    /**
     * Busca um aluno pela sua matricula.
     * 
     * @param matricula matricula do aluno a ser buscado
     * @return o aluno encontrado
     * @throws EntityNotFoundException caso o aluno não seja encontrado
     */
    public Aluno getAlunoByMatricula(String matricula) {
        return alunoRepository.findById(matricula)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado para a matricula: " + matricula));
    }

    // Método para excluir um aluno por matrícula
    public void excluirAluno(String matricula) {
        alunoRepository.deleteById(matricula);
    }

    // Método para atualizar um aluno existente
    public Optional<Aluno> atualizarAluno(String matricula, Aluno alunoAtualizado) {
        return alunoRepository.findById(matricula).map(alunoExistente -> {
            alunoExistente.setNome(alunoAtualizado.getNome());
            alunoExistente.setDataNascimento(alunoAtualizado.getDataNascimento());
            alunoExistente.setEmail(alunoAtualizado.getEmail());
            alunoExistente.setTelefone(alunoAtualizado.getTelefone());
            alunoExistente.setEndereco(alunoAtualizado.getEndereco());
            return alunoRepository.save(alunoExistente);
        });
    }
}
