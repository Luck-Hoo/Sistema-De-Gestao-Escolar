package com.escola.sia.model.relacoes;

import jakarta.persistence.*;

import com.escola.sia.model.Disciplina;
import com.escola.sia.model.Monitor;
import com.escola.sia.model.relacoes.chavesCompostas.MonitorDisciplinaId;

@Entity
@Table(name = "Monitor_disciplina")
@IdClass(MonitorDisciplinaId.class) // Define a classe para chave composta
public class MonitorDisciplina {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_monitor", nullable = false)
    private Monitor monitor;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    // Getters e Setters

    public Monitor getMonitor() {
        return this.monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
