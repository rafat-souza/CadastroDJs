package com.rafael.CadastroDJs.DJs;

import com.rafael.CadastroDJs.Eventos.EventoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class DJModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dj;
    private String label;
    private int idade;
    private String email;

    

    public DJModel() {
    }

    public DJModel(String dj, String label, int idade, String email) {
        this.dj = dj;
        this.label = label;
        this.idade = idade;
        this.email = email;
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
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
