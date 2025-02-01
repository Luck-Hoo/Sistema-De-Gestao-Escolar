package com.escola.sia.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Define 'matricula' como chave primária
    @Column(name = "matricula_aluno", length = 10, nullable = false, unique = true) // Restrições correspondentes à //
                                                                                    // tabela
    private String matricula;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_nascimento")
    private String dataNascimento; // Usar String para simplificação ou LocalDate para maior precisão

    @Column(unique = true)
    private String email;
    private String telefone;
    private String endereco;

    // Construtor vazio (necessário para JPA)
    public Aluno() {
    }

    // Construtor com parâmetros
    public Aluno(String matricula, String nome, String dataNascimento, String email, String telefone, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters e Setters com notificações

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
