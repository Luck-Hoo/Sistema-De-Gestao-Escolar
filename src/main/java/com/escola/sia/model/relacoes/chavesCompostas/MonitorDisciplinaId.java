package com.escola.sia.model.relacoes.chavesCompostas;

import java.io.Serializable;
import java.util.Objects;

public class MonitorDisciplinaId implements Serializable {

    private int monitor;
    private int disciplina;

    // Construtores padrão, equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MonitorDisciplinaId that = (MonitorDisciplinaId) o;
        return Objects.equals(monitor, that.monitor) && Objects.equals(disciplina, that.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monitor, disciplina);
    }
}
