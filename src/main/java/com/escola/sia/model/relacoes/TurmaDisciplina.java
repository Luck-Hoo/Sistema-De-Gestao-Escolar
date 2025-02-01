package com.escola.sia.model.relacoes;

import com.escola.sia.model.Disciplina;
import com.escola.sia.model.Turma;
import com.escola.sia.model.relacoes.chavesCompostas.TurmaDisciplinaId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(TurmaDisciplinaId.class)
@Table(name = "Turma_Disciplina")
public class TurmaDisciplina {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false) // Substitua @Column por @JoinColumn
    private Turma turma;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false) // Substitua @Column por @JoinColumn
    private Disciplina disciplina;

    // Getters e Setters com notificações
    public Turma getIdTurma() {
        return turma;
    }

    public void setIdTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getIdDisciplina() {
        return disciplina;
    }

    public void setIdDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
