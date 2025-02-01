package com.escola.sia.controller;

import com.escola.sia.model.Aluno;
import com.escola.sia.service.AlunoService;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    /**
     * Retorna a lista de alunos para o template.
     * 
     * @param model modelo para a view.
     * @return template alunos/alunos
     */
    @GetMapping
    public String listarAlunos(Model model) {
        List<Aluno> alunos = alunoService.listarAlunos();
        model.addAttribute("alunos", alunos);
        model.addAttribute("aluno", new Aluno());
        return "aluno/alunos";
    }

    /**
     * Adiciona um novo aluno.
     * 
     * @param aluno aluno a ser cadastrado.
     * @return redireciona para a lista de alunos.
     */
    @PostMapping
    public String adicionarAluno(@ModelAttribute @Valid Aluno aluno) {
        alunoService.salvarAluno(aluno);
        return "redirect:/alunos";
    }

    /**
     * Edita um aluno existente.
     * 
     * @param matricula matricula do aluno.
     * @param model     modelo da view.
     * @return template alunos/editar.
     */
    @GetMapping("/editar/{matricula}")
    public String editarAluno(@PathVariable String matricula, Model model) {
        Optional<Aluno> aluno = alunoService.buscarAlunoPorMatricula(matricula);

        model.addAttribute("aluno", aluno);
        return "aluno/alunoEditar";
    }

    /**
     * Atualiza os dados do aluno
     * 
     * @param aluno aluno a ser atualizado.
     * @return redireciona para a lista de alunos.
     */
    @PostMapping("/editar")
    public String atualizarAluno(@ModelAttribute @Valid Aluno aluno) {
        alunoService.salvarAluno(aluno);
        return "redirect:/alunos";
    }

    /**
     * Deleta um aluno.
     * 
     * @param matricula matricula do aluno a ser deletado.
     * @return redireciona para a lista de alunos.
     */
    @GetMapping("/excluir/{matricula}")
    public String excluirAluno(@PathVariable String matricula) {
        alunoService.excluirAluno(matricula);
        return "redirect:/alunos";
    }
}