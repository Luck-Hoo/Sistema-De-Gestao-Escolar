package com.escola.sia.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.escola.sia.model.Formacao;
import com.escola.sia.service.FormacoesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formacao")
public class FormacaoController {
    private final FormacoesService formacoesService;

    public FormacaoController(FormacoesService formacoesService) {
        this.formacoesService = formacoesService;
    }

    @GetMapping
    public String listarFormacoes(Model model) {
        List<Formacao> formacoes = formacoesService.getAllFormacoes(); // Obtenha a lista de formações
        model.addAttribute("formacoes", formacoes);
        return "formacoes/formacoes";
    }

}
