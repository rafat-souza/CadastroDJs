package com.rafael.CadastroDJs.Eventos;

import com.rafael.CadastroDJs.DJs.DJModel;
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

    @OneToMany(mappedBy = "eventos")
    private List<DJModel> djs;


}
