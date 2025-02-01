package com.escola.sia.controller.relacoes;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.escola.sia.model.relacoes.MatriculaTurma;
import com.escola.sia.service.relacoes.MatriculaTurmaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaTurmaController {

    private final MatriculaTurmaService matriculaTurmaService;

    public MatriculaTurmaController(MatriculaTurmaService matriculaTurmaService) {
        this.matriculaTurmaService = matriculaTurmaService;
    }

    @GetMapping
    public String listarMatriculas(Model model) {
        List<MatriculaTurma> matriculas = matriculaTurmaService.listarMatriculaTurma();
        model.addAttribute("matriculas", matriculas);
        return "matriculaTurma/matriculaTurma";
    }
}