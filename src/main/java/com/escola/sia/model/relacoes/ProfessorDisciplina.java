package com.escola.sia.model.relacoes;

import com.escola.sia.model.Disciplina;
import com.escola.sia.model.Professor;
import com.escola.sia.model.relacoes.chavesCompostas.ProfessorDisciplinaId;

import jakarta.persistence.*;

@Entity
@Table(name = "Professor_disciplina")
@IdClass(ProfessorDisciplinaId.class) // Usando chave composta
public class ProfessorDisciplina {

    @Id
    @Column(name = "matricula_Professor", length = 10) // Adicione o length aqui
    private String matriculaProfessor;

    @Id
    @Column(name = "id_disciplina")
    private Integer idDisciplina;

    @ManyToOne
    @JoinColumn(name = "matricula_Professor", referencedColumnName = "matricula_Professor", insertable = false, updatable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina", insertable = false, updatable = false)
    private Disciplina disciplina;

    public ProfessorDisciplina() {
    }

    public ProfessorDisciplina(String matriculaProfessor, Integer idDisciplina) {
        this.matriculaProfessor = matriculaProfessor;
        this.idDisciplina = idDisciplina;
    }

    public String getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public void setMatriculaProfessor(String matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
