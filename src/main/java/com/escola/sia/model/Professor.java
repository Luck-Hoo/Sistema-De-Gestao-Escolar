package com.escola.sia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Professor {

    @Id
    @Column(name = "matricula_Professor", length = 10)
    private String idProfessor;

    private String nome;
    private String email;
    private String telefone;

    @Column(name = "data_admissao")
    private String dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "id_formacao") // Relaciona com a coluna id_formacao da tabela Formacao
    private Formacao formacao; // Relacionamento com a classe Formacao, não mais com um int

    // Construtor completo
    public Professor(String idProfessor, String nome, String email, String telefone, String dataAdmissao,
            Formacao formacao) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
        this.formacao = formacao; // Agora passamos a instância de Formacao
    }

    public Professor() {
    }

    // Getters e Setters
    public String getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }
}
