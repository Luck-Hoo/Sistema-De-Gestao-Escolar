package com.escola.sia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.escola.sia.model.NotaAluno;
import com.escola.sia.model.Aluno;
import com.escola.sia.repository.NotaAlunoRepository;
import com.escola.sia.repository.AlunoRepository;

@Service
public class NotaAlunoService {
    private final NotaAlunoRepository notaAlunoRepository;
    private final AlunoRepository alunoRepository;

    public NotaAlunoService(NotaAlunoRepository notaAlunoRepository, AlunoRepository alunoRepository) {
        this.notaAlunoRepository = notaAlunoRepository;
        this.alunoRepository = alunoRepository;
    }

    // Método para salvar um professor
    public NotaAluno salvarNotaAluno(NotaAluno notaAluno) {
        return notaAlunoRepository.save(notaAluno);
    }

    // Método para buscar todos os professores
    public List<NotaAluno> listarNotasAluno() {
        return notaAlunoRepository.findAll();
    }

    // Método para buscar um professor por ID
    public Optional<NotaAluno> buscarNotaPorId(int id) {
        return notaAlunoRepository.findById(id);
    }

    // Método para excluir um professor por ID
    public void excluirNota(int id) {
        notaAlunoRepository.deleteById(id);
    }

    // Método para atualizar uma nota de aluno
    public NotaAluno atualizarNotaAluno(int id, NotaAluno novaNotaAluno) {
        Optional<NotaAluno> notaAlunoExistente = notaAlunoRepository.findById(id);
        if (notaAlunoExistente.isPresent()) {
            NotaAluno notaAlunoAtualizada = notaAlunoExistente.get();

            // Verificar e atualizar os campos conforme as regras do banco de dados
            BigDecimal novaNota = novaNotaAluno.getNota();
            if (novaNota.compareTo(novaNota.ZERO) >= 0 && novaNota.compareTo(novaNota.TEN) <= 10) {
                notaAlunoAtualizada.setNota(novaNota);
            } else {
                throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
            }

            if (novaNotaAluno.getSemestre().matches("^[0-9]{4}\\.[1-2]$")) {
                notaAlunoAtualizada.setSemestre(novaNotaAluno.getSemestre());
            } else {
                throw new IllegalArgumentException("Formato de semestre inválido. Use o formato 'AAAA.S'");
            }

            if (novaNotaAluno.getEtapa().equals("P1") || novaNotaAluno.getEtapa().equals("P2")
                    || novaNotaAluno.getEtapa().equals("P3")
                    || novaNotaAluno.getEtapa().equals("Recuperação")
                    || novaNotaAluno.getEtapa().equals("Prova Final")) {
                notaAlunoAtualizada.setEtapa(novaNotaAluno.getEtapa());
            } else {
                throw new IllegalArgumentException(
                        "Etapa inválida. As etapas permitidas são: P1, P2, P3, Recuperação, Prova Final.");
            }

            // Atualizando o aluno baseado na matricula
            String matriculaAluno = novaNotaAluno.getAluno().getMatricula();
            Optional<Aluno> alunoExistente = alunoRepository.findById(matriculaAluno);
            if (alunoExistente.isPresent()) {
                notaAlunoAtualizada.setAluno(alunoExistente.get());
            } else {
                throw new IllegalArgumentException("Aluno não encontrado com a matrícula: " + matriculaAluno);
            }

            // Atualizando outros campos
            notaAlunoAtualizada.setDisciplina(novaNotaAluno.getDisciplina());

            return notaAlunoRepository.save(notaAlunoAtualizada);
        } else {
            throw new RuntimeException("NotaAluno não encontrado para o id: " + id);
        }
    }

    public static final String SEMESTRE_REGEX = "^[0-9]{4}\\.[1-2]$";
    public static final String ETAPA_P1 = "P1";
    public static final String ETAPA_P2 = "P2";
    public static final String ETAPA_P3 = "P3";
    public static final String ETAPA_RECUPERACAO = "Recuperação";
    public static final String ETAPA_PROVA_FINAL = "Prova Final";

    /**
     * Agrupa e organiza as notas por matéria e avaliação para um determinado aluno.
     *
     * @param aluno O aluno para o qual as notas serão agrupadas.
     * @return Um mapa onde a chave é o nome da matéria e o valor é uma lista das
     *         notas nas avaliações (P1, P2, P3).
     */
    public Map<String, List<BigDecimal>> getNotasPorMateriaEAvaliacao(Aluno aluno) {
        List<NotaAluno> notas = notaAlunoRepository.findByAluno(aluno);
        Map<String, List<BigDecimal>> notasPorMateria = new HashMap<>();

        for (NotaAluno nota : notas) {
            if (nota.getDisciplina() != null && nota.getDisciplina().getNome() != null) { // check if they are null
                String disciplinaNome = nota.getDisciplina().getNome();
                if (!notasPorMateria.containsKey(disciplinaNome)) {
                    List<BigDecimal> notasAvaliacao = new ArrayList<>(3);
                    notasAvaliacao.add(null);
                    notasAvaliacao.add(null);
                    notasAvaliacao.add(null);
                    notasPorMateria.put(disciplinaNome, notasAvaliacao);
                }

                List<BigDecimal> notasAvaliacao = notasPorMateria.get(disciplinaNome);
                String etapa = nota.getEtapa();
                int index = 0;
                if (etapa.equalsIgnoreCase("p1"))
                    index = 0;
                else if (etapa.equalsIgnoreCase("p2"))
                    index = 1;
                else if (etapa.equalsIgnoreCase("p3"))
                    index = 2;

                notasAvaliacao.set(index, nota.getNota());
            }

        }
        return notasPorMateria;
    }
}
