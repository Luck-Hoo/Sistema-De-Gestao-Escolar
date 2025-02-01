package com.escola.sia.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private int idDisciplina;
    private String nome;

    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @Column(name = "nivel_academico")
    private String nivelAcademico;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Construtor sem ID (autoincrementado no BD)
    public Disciplina(String nome, int cargaHoraria, String nivelAcademico) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.nivelAcademico = nivelAcademico;
    }

    // Construtor padrão
    public Disciplina() {
    }

    // Métodos de suporte a observadores
    public void addObserver(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeObserver(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    // Getters e Setters com notificações
    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        int oldValue = this.idDisciplina;
        this.idDisciplina = idDisciplina;
        support.firePropertyChange("idDisciplina", oldValue, idDisciplina);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldValue = this.nome;
        this.nome = nome;
        support.firePropertyChange("nome", oldValue, nome);
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        int oldValue = this.cargaHoraria;
        this.cargaHoraria = cargaHoraria;
        support.firePropertyChange("cargaHoraria", oldValue, cargaHoraria);
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        String oldValue = this.nivelAcademico;
        this.nivelAcademico = nivelAcademico;
        support.firePropertyChange("nivelAcademico", oldValue, nivelAcademico);
    }
}
