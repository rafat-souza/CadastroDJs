package com.rafael.CadastroDJs.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "tb_djs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DJModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    private String dj;

    private String label;
    private int idade;

    @NotBlank
    private String email;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoModel evento;

}
