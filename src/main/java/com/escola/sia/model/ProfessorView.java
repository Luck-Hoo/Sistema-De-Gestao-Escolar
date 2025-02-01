/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escola.sia.model;

/**
 *
 * @author Lucas98
 */
public class ProfessorView {
    private int idProfessor;
    private String nome;
    private String email;
    private String telefone;
    private String dataAdmissao;
    private String nomeFormacao;

    public ProfessorView() {
    }

    public ProfessorView(int idProfessor, String nome, String email, String telefone, String dataAdmissao,
            String nomeFormacao) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
        this.nomeFormacao = nomeFormacao;
    }

    // Getters e Setters
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
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

    public String getNomeFormacao() {
        return nomeFormacao;
    }

    public void setNomeFormacao(String nomeFormacao) {
        this.nomeFormacao = nomeFormacao;
    }

}
