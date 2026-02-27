package com.rafael.CadastroDJs.DJs;

import com.rafael.CadastroDJs.Eventos.EventoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
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
    private EventoModel eventos;


}
