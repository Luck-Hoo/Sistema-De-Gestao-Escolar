package com.escola.sia.controller;

import com.escola.sia.model.Aluno;
import com.escola.sia.model.NotaAluno;
import com.escola.sia.service.AlunoService;
import com.escola.sia.service.DisciplinaService;
import com.escola.sia.service.NotaAlunoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Alterado para Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller // Alterado para Controller
@RequestMapping("/notas")
public class NotaAlunoController {

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private NotaAlunoService notaAlunoService;

    @Autowired
    private AlunoService alunoService;

    public NotaAlunoController(NotaAlunoService notaAlunoService, AlunoService alunoService) {
        this.notaAlunoService = notaAlunoService;
        this.alunoService = alunoService;
    }

    // Obter todas as notas
    @GetMapping
    public String listarTodas(Model model) {
        List<NotaAluno> notas = notaAlunoService.listarNotasAluno();
        model.addAttribute("notas", notas);
        model.addAttribute("notaAluno", new NotaAluno());
        model.addAttribute("disciplinas", disciplinaService);
        model.addAttribute("alunoService", alunoService);
        return "notas/notas"; // Nome do template Thymeleaf
    }

    // Obter uma nota por ID
    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Integer id, Model model) {
        Optional<NotaAluno> notaOptional = notaAlunoService.buscarNotaPorId(id);
        if (notaOptional.isPresent()) {
            model.addAttribute("nota", notaOptional.get());
            return "notas/Matriz"; // Nome do template para visualizar os detalhes de uma nota
        } else {
            return "notFound"; // Template para "não encontrado"
        }
    }

    /**
     * Cria uma nova nota de aluno.
     * 
     * @param notaAluno nota a ser criada
     * @return redireciona para a lista de notas
     */
    @PostMapping
    public String criar(@ModelAttribute @Valid NotaAluno notaAluno) {
        notaAlunoService.salvarNotaAluno(notaAluno);
        return "redirect:/notas";
    }

    // Atualizar uma nota existente
    @PutMapping("/{id}")
    public Optional<NotaAluno> atualizarNotaAluno(Integer id, NotaAluno notaAtualizada) {
        Optional<NotaAluno> notaExistente = notaAlunoService.buscarNotaPorId(id);
        if (notaExistente.isPresent()) {
            // Atualizar a nota com as informações de notaAtualizada
            // Suponha que você tenha um método para atualizar a entidade
            notaExistente.get().setNota(notaAtualizada.getNota());
            // Outras atualizações, conforme necessário
            return Optional.of(notaExistente.get()); // Retorna a nota atualizada
        } else {
            return Optional.empty(); // Caso a nota não seja encontrada
        }
    }

    // Deletar uma nota por ID
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        Optional<NotaAluno> notaExistente = notaAlunoService.buscarNotaPorId(id);
        if (notaExistente.isPresent()) {
            notaAlunoService.excluirNota(id);
            return "redirect:notas/notas"; // Redireciona para a lista de notas
        } else {
            return "notFound"; // Template para "não encontrado"
        }
    }

    /**
     * Exibe a matriz de notas do aluno.
     * 
     * @param alunoMatricula matricula do aluno
     * @param model          modelo para passar os dados para a view.
     * @return o template "notas/matriz".
     */
    @GetMapping("/{alunoMatricula}/matriz")
    public String mostrarMatrizNotas(@PathVariable String alunoMatricula, Model model) {
        Aluno aluno = alunoService.getAlunoByMatricula(alunoMatricula);
        Map<String, List<BigDecimal>> notasPorMateria = notaAlunoService.getNotasPorMateriaEAvaliacao(aluno);
        model.addAttribute("alunoNome", aluno.getNome());
        model.addAttribute("notasPorMateria", notasPorMateria);
        model.addAttribute("alunoMatricula", alunoMatricula);
        return "notas/matriz";
    }
}
