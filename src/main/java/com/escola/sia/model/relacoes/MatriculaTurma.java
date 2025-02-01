package com.escola.sia.model.relacoes;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.escola.sia.model.Aluno;
import com.escola.sia.model.Turma;

@Entity
@Table(name = "Matricula_turma", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "matricula_aluno", "id_turma" })
})
public class MatriculaTurma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula_turma")
    private Integer idMatricula;

    @OneToOne
    @JoinColumn(name = "matricula", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;

    @Column(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_matricula", nullable = false, columnDefinition = "ENUM('Ativa', 'Cancelada', 'Trancada')")
    private StatusMatricula statusMatricula = StatusMatricula.Ativa;

    // Getters e Setters
    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Aluno getMatriculaAluno() {
        return aluno;
    }

    public void setMatriculaAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getIdTurma() {
        return turma;
    }

    public void setIdTurma(Turma turma) {
        this.turma = turma;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public StatusMatricula getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(StatusMatricula statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    // Enum para status da matrícula
    public enum StatusMatricula {
        Ativa, Cancelada, Trancada
    }
}
