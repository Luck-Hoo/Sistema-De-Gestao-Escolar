package com.escola.sia.model.relacoes;

import jakarta.persistence.*;
import java.time.LocalTime;

import com.escola.sia.model.Disciplina;
import com.escola.sia.model.Professor;
import com.escola.sia.model.Turma;

@Entity
@Table(name = "Horario_Aula", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "matricula_Professor", "id_turma", "id_disciplina", "dia_semana", "horario" })
})
public class HorarioAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Integer idHorario;

    @ManyToOne
    @JoinColumn(name = "matricula_Professor", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    @Transient
    @Column(name = "matricula_Professor", length = 10, insertable = false, updatable = false)
    private String matriculaProfessor;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana", nullable = false)
    private DiaSemana diaSemana;

    @Column(name = "horario", nullable = false)
    private LocalTime horario;

    // Getters e Setters
    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    // Enum para os dias da semana
    public enum DiaSemana {
        Segunda, Terça, Quarta, Quinta, Sexta
    }
}
