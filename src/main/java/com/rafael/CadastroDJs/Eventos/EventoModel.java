package com.rafael.CadastroDJs.Eventos;

import com.rafael.CadastroDJs.DJs.DJModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_evento")
public class EventoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String evento;
    private String local;
    private int duracao;
    private DJModel djs;

    public EventoModel() {
    }

    public EventoModel(String evento, String local, int duracao){
        this.evento = evento;
        this.local = local;
        this.duracao = duracao;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

}
