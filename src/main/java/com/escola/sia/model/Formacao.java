package com.escola.sia.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_formacao; // Usar Integer ao invés de int para permitir o valor null antes de persistir

    private String nome;

    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @Column(name = "nivel_academico")
    private String nivelAcademico;

    // Relacionamento bidirecional com a classe Professor
    @OneToMany(mappedBy = "formacao") // Nome do atributo na classe Professor
    private List<Professor> professores;

    // Construtor completo
    public Formacao(Integer id_formacao, String nome, int cargaHoraria, String nivelAcademico) {
        this.id_formacao = id_formacao;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.nivelAcademico = nivelAcademico;
    }

    public Formacao() {
        // Construtor vazio para o JPA
    }

    // Getters e Setters
    public Integer getId_formacao() {
        return id_formacao;
    }

    public void setId_formacao(Integer id_formacao) {
        this.id_formacao = id_formacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
}
