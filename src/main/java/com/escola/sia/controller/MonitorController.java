package com.escola.sia.controller;

import com.escola.sia.model.Monitor;
import com.escola.sia.service.MonitorService;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/monitores")
public class MonitorController {
    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    // Listar todos os monitores
    @GetMapping
    public String listarMonitores(Model model) {
        model.addAttribute("monitores", monitorService.listarMonitores());
        return "monitor/monitores";
    }

    // Formulário para criar novo monitor
    @GetMapping("/novo")
    public String novoMonitorForm(Model model) {
        model.addAttribute("monitor", new Monitor());
        return "monitor/formulario";
    }

    // Salvar novo monitor
    @PostMapping
    public String salvarMonitor(@ModelAttribute("monitor") Monitor monitor) {
        monitorService.salvarMonitor(monitor);
        return "redirect:/monitores";
    }

    // Formulário para editar monitor existente
    @GetMapping("/editar/{id}")
    public String editarMonitorForm(@PathVariable int id, Model model) {
        Optional<Monitor> monitor = monitorService.buscarMonitorPorId(id);
        model.addAttribute("monitor", monitor);
        return "monitor/formulario";
    }

    // Atualizar monitor
    @PostMapping("/{id}")
    public String atualizarMonitor(@PathVariable int id, @ModelAttribute("monitor") Monitor monitorAtualizado) {
        monitorService.atualizarMonitor(id, monitorAtualizado);
        return "redirect:/monitores";
    }

    // Excluir monitor
    @GetMapping("/excluir/{id}")
    public String excluirMonitor(@PathVariable int id) {
        monitorService.excluirMonitor(id);
        return "redirect:/monitores";
    }
}
