// ProfessorDisciplinaId.java (Your @IdClass)
package com.escola.sia.model.relacoes.chavesCompostas;

import java.io.Serializable;
import java.util.Objects;

public class ProfessorDisciplinaId implements Serializable {
    private String matriculaProfessor;
    private Integer idDisciplina;

    // Required no-arg constructor, getters, setters, equals, hashcode
    public ProfessorDisciplinaId() {

    }

    public ProfessorDisciplinaId(String matriculaProfessor, Integer idDisciplina) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProfessorDisciplinaId that = (ProfessorDisciplinaId) o;
        return Objects.equals(matriculaProfessor, that.matriculaProfessor)
                && Objects.equals(idDisciplina, that.idDisciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriculaProfessor, idDisciplina);
    }
}