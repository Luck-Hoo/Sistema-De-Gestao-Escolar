/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.escola.sia.model.relacoes;

/**
 *
 * @author Lucas98
 */
public class HorarioAulaView {
    private int idHorario;
    private String nomeTurma;
    private String nomeDisciplina;
    private String nomeProfessor;
    private String diaSemana;
    private String horario;

    // Construtores, getters, setters, toString...

    public HorarioAulaView(int idHorario, String nomeTurma, String nomeDisciplina, String nomeProfessor,
            String diaSemana, String horario) {
        this.idHorario = idHorario;
        this.nomeTurma = nomeTurma;
        this.nomeDisciplina = nomeDisciplina;
        this.nomeProfessor = nomeProfessor;
        this.diaSemana = diaSemana;
        this.horario = horario;
    }

    public HorarioAulaView() {
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
