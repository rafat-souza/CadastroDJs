package com.rafael.CadastroDJs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_evento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String evento;
    private String local;
    private int duracao;

    @OneToMany(mappedBy = "evento")
    private List<DJModel> djs;


}
