package com.escola.sia.controller.relacoes;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.escola.sia.model.relacoes.MonitorDisciplina;
import com.escola.sia.service.relacoes.MonitorDisciplinaService;

@Controller
@RequestMapping("/monitores-disciplinas")
public class MonitorDisciplinaController {

    private final MonitorDisciplinaService monitorDisciplinaService;

    public MonitorDisciplinaController(MonitorDisciplinaService monitorDisciplinaService) {
        this.monitorDisciplinaService = monitorDisciplinaService;
    }

    @GetMapping
    public String listarMonitoresDisciplinas(Model model) {
        List<MonitorDisciplina> monitoresDisciplinas = monitorDisciplinaService.listarMonitorDisciplina();
        model.addAttribute("monitoresDisciplinas", monitoresDisciplinas);
        return "monitorDisciplina/monitorDisciplina";
    }
}