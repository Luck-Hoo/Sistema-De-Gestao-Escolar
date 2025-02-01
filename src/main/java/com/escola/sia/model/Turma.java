package com.escola.sia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Integer idTurma;
    @Column(name = "nome_turma")
    private String nomeTurma;
    private int ano_letivo;
    private String turno;

    public Turma(Integer idTurma, String nomeTurma, int ano_letivo, String turno) {
        this.nomeTurma = nomeTurma;
        this.ano_letivo = ano_letivo;
        this.turno = turno;

    }

    public Turma() {

    }

    // Getters e Setters com notificações
    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public int getAnoLetivo() {
        return ano_letivo;
    }

    public void setAnoLetivo(int ano_letivo) {
        this.ano_letivo = ano_letivo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
