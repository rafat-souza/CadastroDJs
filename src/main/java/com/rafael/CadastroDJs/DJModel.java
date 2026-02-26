package com.rafael.CadastroDJs;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class DJModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String label;
    private int idade;
    private String email;

    public DJModel() {
    }

    public DJModel(String nome, String label, int idade, String email) {
        this.nome = nome;
        this.label = label;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
