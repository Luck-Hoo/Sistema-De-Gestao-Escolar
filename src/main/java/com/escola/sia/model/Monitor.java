package com.escola.sia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monitor")
    private int idMonitor;
    private String nome;
    private String email;
    private String telefone;

    public Monitor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;

    }

    public Monitor() {

    }

    // Getters e Setters com notificações
    public int getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
