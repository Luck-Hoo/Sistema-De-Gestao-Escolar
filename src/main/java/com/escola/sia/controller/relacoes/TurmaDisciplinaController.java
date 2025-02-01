package com.escola.sia.controller.relacoes;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.escola.sia.model.relacoes.TurmaDisciplina;
import com.escola.sia.service.relacoes.TurmaDisciplinaService;

@Controller
@RequestMapping("/turmas-disciplinas")
public class TurmaDisciplinaController {

    private final TurmaDisciplinaService turmaDisciplinaService;

    public TurmaDisciplinaController(TurmaDisciplinaService turmaDisciplinaService) {
        this.turmaDisciplinaService = turmaDisciplinaService;
    }

    @GetMapping
    public String listarTurmasDisciplinas(Model model) {
        List<TurmaDisciplina> turmasDisciplinas = turmaDisciplinaService.listarTurmaDisciplina();
        model.addAttribute("turmasDisciplinas", turmasDisciplinas);
        return "turmaDisciplina/turmaDisciplina";
    }
}