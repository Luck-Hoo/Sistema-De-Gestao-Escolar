package com.escola.sia.controller;

import com.escola.sia.model.Turma;
import com.escola.sia.service.TurmaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    // Listar todas as turmas
    @GetMapping
    public String listarTurmas(Model model) {
        model.addAttribute("turmas", turmaService.listarTurmas());
        return "turmas/turmas"; // Caminho do template Thymeleaf
    }

    // Formulário para criar uma nova turma
    @GetMapping("/nova")
    public String formularioNovaTurma(Model model) {
        model.addAttribute("turma", new Turma());
        return "turmas/nova-turma"; // Caminho do template para criar nova turma
    }

    // Salvar uma nova turma
    @PostMapping
    public String salvarTurma(@ModelAttribute Turma turma) {
        turmaService.salvarTurma(turma);
        return "redirect:/turmas"; // Redireciona para a lista de turmas
    }

    // Formulário para editar uma turma existente
    @GetMapping("/editar/{id}")
    public String formularioEditarTurma(@PathVariable int id, Model model) {
        Optional<Turma> turmaOptional = turmaService.buscarTurmaPorId(id);
        if (turmaOptional.isPresent()) {
            model.addAttribute("turma", turmaOptional.get());
            return "turmas/editar-turma"; // Caminho do template para editar turma
        } else {
            return "redirect:/turmas"; // Redireciona se o ID não for encontrado
        }
    }

    // Atualizar uma turma existente
    @PostMapping("/editar/{id}")
    public String atualizarTurma(@PathVariable int id, @ModelAttribute Turma turmaAtualizada) {
        turmaService.atualizarTurma(id, turmaAtualizada);
        return "redirect:/turmas";
    }

    // Excluir uma turma
    @GetMapping("/excluir/{id}")
    public String excluirTurma(@PathVariable int id) {
        turmaService.excluirTurma(id);
        return "redirect:/turmas";
    }
}
