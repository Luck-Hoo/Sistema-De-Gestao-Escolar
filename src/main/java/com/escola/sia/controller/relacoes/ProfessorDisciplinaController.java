package com.escola.sia.controller.relacoes;

import com.escola.sia.model.Disciplina;
import com.escola.sia.model.Professor;
import com.escola.sia.model.relacoes.ProfessorDisciplina;
import com.escola.sia.model.relacoes.chavesCompostas.ProfessorDisciplinaId;
import com.escola.sia.service.DisciplinaService;
import com.escola.sia.service.relacoes.ProfessorDisciplinaService;
import com.escola.sia.service.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/professorDisciplinas")
public class ProfessorDisciplinaController {

    private final ProfessorDisciplinaService professorDisciplinaService;
    private final ProfessorService professorService;
    private final DisciplinaService disciplinaService;

    public ProfessorDisciplinaController(ProfessorDisciplinaService professorDisciplinaService,
            ProfessorService professorService, DisciplinaService disciplinaService) {
        this.professorDisciplinaService = professorDisciplinaService;
        this.professorService = professorService;
        this.disciplinaService = disciplinaService;
    }

    // Endpoint para listar todas as relações
    @GetMapping
    public String listarRelacoes(Model model) {
        List<ProfessorDisciplina> relacoes = professorDisciplinaService.listarRelacoes();
        model.addAttribute("relacoes", relacoes);
        return "professorDisciplinas/professorDisciplina_listar";
    }

    // Endpoint para exibir o formulário de criação
    @GetMapping("/novo")
    public String exibirFormularioCriacao(Model model) {
        List<Professor> professores = professorService.listarProfessores();
        List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();

        model.addAttribute("professorDisciplina", new ProfessorDisciplina());
        model.addAttribute("professores", professores);
        model.addAttribute("disciplinas", disciplinas);
        return "professorDisciplina/professorDisciplina_novo";
    }

    // Endpoint para processar a criação de uma nova relação
    @PostMapping("/novo")
    public String salvarRelacao(@ModelAttribute ProfessorDisciplina professorDisciplina,
            RedirectAttributes redirectAttributes) {
        try {
            professorDisciplinaService.salvarRelacao(professorDisciplina);
            redirectAttributes.addFlashAttribute("success", "Relação professor-disciplina criada com sucesso!");
            return "redirect:/professorDisciplinas";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/professorDisciplinas";
        }
    }

    // Endpoint para exibir o formulário de edição
    @GetMapping("/editar/{matriculaProfessor}/{idDisciplina}")
    public String exibirFormularioEdicao(@PathVariable String matriculaProfessor, @PathVariable Integer idDisciplina,
            Model model) {
        ProfessorDisciplinaId id = new ProfessorDisciplinaId(matriculaProfessor, idDisciplina);
        Optional<ProfessorDisciplina> optionalRelacao = professorDisciplinaService.buscarRelacaoPorId(id);
        List<Professor> professores = professorService.listarProfessores();
        List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();

        if (optionalRelacao.isPresent()) {
            model.addAttribute("professorDisciplina", optionalRelacao.get());
            model.addAttribute("professores", professores);
            model.addAttribute("disciplinas", disciplinas);
            return "professorDisciplina/professorDisciplina_editar";
        } else {
            model.addAttribute("error", "Relação professor-disciplina não encontrada");
            return "redirect:/professorDisciplinas";
        }
    }

    // Endpoint para processar a atualização de uma relação
    @PostMapping("/editar/{matriculaProfessor}/{idDisciplina}")
    public String atualizarRelacao(@PathVariable String matriculaProfessor, @PathVariable Integer idDisciplina,
            @ModelAttribute ProfessorDisciplina professorDisciplina, RedirectAttributes redirectAttributes) {
        ProfessorDisciplinaId id = new ProfessorDisciplinaId(matriculaProfessor, idDisciplina);
        try {
            professorDisciplinaService.atualizarRelacao(id, professorDisciplina);
            redirectAttributes.addFlashAttribute("success", "Relação professor-disciplina atualizada com sucesso!");
            return "redirect:/professorDisciplinas";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/professorDisciplinas";
        }
    }

    // Endpoint para excluir uma relação
    @GetMapping("/excluir/{matriculaProfessor}/{idDisciplina}")
    public String excluirRelacao(@PathVariable String matriculaProfessor, @PathVariable Integer idDisciplina,
            RedirectAttributes redirectAttributes) {
        ProfessorDisciplinaId id = new ProfessorDisciplinaId(matriculaProfessor, idDisciplina);
        try {
            professorDisciplinaService.excluirRelacaoPorId(id);
            redirectAttributes.addFlashAttribute("success", "Relação professor-disciplina excluída com sucesso!");
            return "redirect:/professorDisciplinas";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/professorDisciplinas";
        }
    }

    // Endpoint para excluir todas as relações de um professor
    @GetMapping("/excluirPorProfessor/{matriculaProfessor}")
    public String excluirRelacoesPorProfessor(@PathVariable String matriculaProfessor,
            RedirectAttributes redirectAttributes) {
        try {
            professorDisciplinaService.excluirRelacoesPorProfessor(matriculaProfessor);
            redirectAttributes.addFlashAttribute("success", "Relações professor-disciplina excluídas com sucesso!");
            return "redirect:/professorDisciplinas";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/professorDisciplinas";
        }
    }

    // Endpoint para excluir todas as relações de uma disciplina
    @GetMapping("/excluirPorDisciplina/{idDisciplina}")
    public String excluirRelacoesPorDisciplina(@PathVariable Integer idDisciplina,
            RedirectAttributes redirectAttributes) {
        try {
            professorDisciplinaService.excluirRelacoesPorDisciplina(idDisciplina);
            redirectAttributes.addFlashAttribute("success", "Relações professor-disciplina excluídas com sucesso!");
            return "redirect:/professorDisciplinas";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/professorDisciplinas";
        }
    }
}
