package com.escola.sia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.escola.sia.model.Formacao;
import com.escola.sia.repository.FormacaoRepository;

@Service
public class FormacoesService {
    private final FormacaoRepository formacaoRepository;

    // Construtor com injeção de dependência
    public FormacoesService(FormacaoRepository formacaoRepository) {
        this.formacaoRepository = formacaoRepository;
    }

    // Método para obter todas as formações
    public List<Formacao> getAllFormacoes() {
        return formacaoRepository.findAll();
    }

    public Optional<Formacao> getFormacaoById(int id_formacao) {
        return formacaoRepository.findById(id_formacao);
    }

}
