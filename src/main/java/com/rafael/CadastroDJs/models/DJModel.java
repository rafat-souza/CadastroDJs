package com.rafael.CadastroDJs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data // Coloca getter e setter para resgatar ou fazer mudanças
@NoArgsConstructor
@AllArgsConstructor
public class DJModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dj;
    private String label;
    private int idade;
    private String email;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoModel evento;


}
