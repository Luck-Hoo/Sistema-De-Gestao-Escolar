package com.escola.sia.controller;

import com.escola.sia.model.Formacao;
import com.escola.sia.model.Professor;
import com.escola.sia.repository.FormacaoRepository;
import com.escola.sia.service.ProfessorService;
import com.escola.sia.service.FormacoesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProfessorController {

    @Autowired
    private FormacoesService formacoesService;

    @Autowired
    private FormacaoRepository formacaoRepository; // Injeção do repositório de Formação

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    // Exibe a lista de professores
    @GetMapping("/professores")
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.listarProfessores());
        model.addAttribute("professor", new Professor()); // Para o formulário de novo professor
        model.addAttribute("formacoes", formacoesService.getAllFormacoes()); // Adiciona as formações ao modelo
        return "professor/professores"; // Este é o nome do arquivo de template HTML
    }

    @PostMapping("/professores")
    public String salvarProfessor(Professor professor, Model model) {
        // Caso você precise apenas listar todas as formações
        Formacao formacao = formacoesService.getAllFormacoes().stream()
                .filter(f -> f.getId_formacao() == professor.getFormacao().getId_formacao())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Formação inválida"));

        professor.setFormacao(formacao); // Define a formação para o professor

        professorService.salvarProfessor(professor); // Chama o serviço para salvar o professor

        return "redirect:professor/professores"; // Redireciona de volta para a lista de professores
    }

    // Exclui um professor
    @GetMapping("/professores/excluir/{idProfessor}")
    public String excluirProfessor(@PathVariable("idProfessor") String idProfessor) {
        professorService.excluirProfessor(idProfessor);
        return "redirect:/professores"; // Redireciona para a lista após exclusão
    }

    // Método para exibir o formulário de edição
    @GetMapping("/professores/editar/{idProfessor}")
    public String editarProfessorForm(@PathVariable("idProfessor") String idProfessor, Model model) {
        Optional<Professor> optionalProfessor = professorService.buscarProfessorPorId(idProfessor);

        if (optionalProfessor.isPresent()) {
            model.addAttribute("professor", optionalProfessor.get());
            model.addAttribute("formacoes", formacaoRepository.findAll()); // Adiciona as formações ao modelo
            return "professor/professor_editar"; // Redireciona para um template de edição
        } else {
            // Caso o professor não seja encontrado, você pode redirecionar ou exibir uma
            // mensagem de erro
            model.addAttribute("error", "Professor não encontrado");
            return "redirect:/professores"; // Ou outra página que preferir
        }
    }

    @PostMapping("/professores/editar/{idProfessor}")
    public String salvarEdicoesProfessor(@PathVariable("idProfessor") String idProfessor,
            @ModelAttribute("professor") Professor professor,
            Model model) {
        try {
            // Chama o método para atualizar o professor
            professorService.atualizarProfessor(idProfessor, professor);
            return "redirect:/professores"; // Redireciona para a lista de professores após a atualização
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/professores"; // Ou exibe a mensagem de erro conforme necessário
        }
    }

}
