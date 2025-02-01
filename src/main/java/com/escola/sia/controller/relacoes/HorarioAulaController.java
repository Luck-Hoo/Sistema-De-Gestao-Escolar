package com.escola.sia.controller.relacoes;

import com.escola.sia.model.Disciplina;
import com.escola.sia.model.Professor;
import com.escola.sia.model.Turma;
import com.escola.sia.model.relacoes.HorarioAula;
import com.escola.sia.repository.ProfessorRepository;
import com.escola.sia.service.DisciplinaService;
import com.escola.sia.service.TurmaService;
import com.escola.sia.service.relacoes.HorarioAulasService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@Slf4j
public class HorarioAulaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private ProfessorRepository professorRepository;

    private final HorarioAulasService horarioAulasService;

    public HorarioAulaController(HorarioAulasService horarioAulasService) {
        this.horarioAulasService = horarioAulasService;
    }

    // Método para exibir todos os horários de aula
    @GetMapping("/horarios")
    public String listarTodos(@RequestParam(name = "orderBy", required = false) String orderBy, Model model) {
        List<HorarioAula> horarios = horarioAulasService.listarHorariosOrdenados(orderBy);
        model.addAttribute("horarios", horarios);
        return "horarios/listar";
    }

    // Método para exibir o formulário de criação de horário de aula
    @GetMapping("/horarios/novo")
    public String mostrarFormularioCriacao(Model model) {
        log.info("Buscando dados para criar novo horário de aula.");
        model.addAttribute("horarioAula", new HorarioAula());
        List<Turma> turmas = turmaService.listarTurmas();
        log.info("Turmas encontradas: " + turmas.size());
        model.addAttribute("turmas", turmas);
        List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();
        log.info("Disciplinas encontradas: " + disciplinas.size());
        model.addAttribute("disciplinas", disciplinas);
        List<Professor> professores = professorRepository.findAll();
        log.info("Professores encontrados: " + professores.size());
        model.addAttribute("professores", professores);
        return "horarios/novo";
    }

    // Método para salvar o horário de aula
    @PostMapping("/horarios/salvar")
    public String salvarHorarioAula(@ModelAttribute HorarioAula horarioAula) {
        horarioAulasService.salvarHorarioAula(horarioAula);
        return "redirect:/horarios";
    }

    // Método para deletar um horário de aula
    @GetMapping("/horarios/deletar/{id}")
    public String deletarHorarioAula(@PathVariable("id") Integer id) {
        horarioAulasService.deletarHorarioAula(id);
        return "redirect:/horarios";
    }

    // Método para buscar horários por dia da semana e horário
    @GetMapping("/horarios/buscar")
    public String buscarPorDiaEHorario(@RequestParam("diaSemana") String diaSemana,
            @RequestParam("horario") String horario, Model model) {
        LocalTime hora = LocalTime.parse(horario);
        List<HorarioAula> horarios = horarioAulasService
                .buscarHorariosPorDiaSemanaEHorario(HorarioAula.DiaSemana.valueOf(diaSemana), hora);
        model.addAttribute("horarios", horarios);
        return "horarios/listar";
    }
}
