package com.escola.sia.model.relacoes.chavesCompostas;

import java.io.Serializable;
import java.util.Objects;

public class TurmaDisciplinaId implements Serializable {

    private int turma;
    private int disciplina;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TurmaDisciplinaId that = (TurmaDisciplinaId) o;
        return Objects.equals(turma, that.turma) && Objects.equals(disciplina, that.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(turma, disciplina);
    }
}
