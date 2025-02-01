package com.escola.sia.controller;

import com.escola.sia.model.Disciplina;
import com.escola.sia.service.DisciplinaService;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    // Listar todas as disciplinas
    @GetMapping
    public String listarDisciplinas(Model model) {
        model.addAttribute("disciplinas", disciplinaService.listarDisciplinas());
        return "disciplinas/disciplinas";
    }

    // Formulário para criar nova disciplina
    @GetMapping("/nova")
    public String novaDisciplinaForm(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "disciplinas/formulario";
    }

    // Salvar nova disciplina
    @PostMapping
    public String salvarDisciplina(@ModelAttribute("disciplina") Disciplina disciplina) {
        disciplinaService.salvarDisciplina(disciplina);
        return "redirect:/disciplinas";
    }

    // Formulário para editar disciplina existente
    @GetMapping("/editar/{id}")
    public String editarDisciplinaForm(@PathVariable int id, Model model) {
        Optional<Disciplina> disciplina = disciplinaService.buscarDisciplinaPorId(id);
        model.addAttribute("disciplina", disciplina);
        return "disciplinas/formulario";
    }

    // Atualizar disciplina

    // Excluir disciplina
    @GetMapping("/excluir/{id}")
    public String excluirDisciplina(@PathVariable int id) {
        disciplinaService.excluirDisciplina(id);
        return "redirect:/disciplinas";
    }
}
