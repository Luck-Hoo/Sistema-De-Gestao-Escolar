package com.escola.sia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Nota_Aluno") // Mapeia para a tabela no banco
public class NotaAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Nota_Aluno")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "matricula_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    @Column(nullable = false)
    @Pattern(regexp = "^[0-9]{4}\\.[1-2]$", message = "Semestre deve ter o formato ano.semestre (ex: 2023.1)")
    private String semestre;

    @DecimalMin(value = "0.00", inclusive = true, message = "Nota deve ser maior ou igual a 0")
    @DecimalMax(value = "10.00", inclusive = true, message = "Nota deve ser menor ou igual a 10")
    @Digits(integer = 2, fraction = 2, message = "Nota deve ter no máximo duas casas decimais")
    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal nota;

    @Column(nullable = false)
    @Pattern(regexp = "P1|P2|P3|Recuperação|Prova Final", message = "Etapa inválida")
    private String etapa;

    // Construtor sem argumentos exigido pelo JPA
    public NotaAluno() {
    }

    // Construtor com parâmetros
    public NotaAluno(Aluno aluno, Disciplina disciplina, String semestre, BigDecimal nota, String etapa) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.nota = nota;
        this.etapa = etapa;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }
}
