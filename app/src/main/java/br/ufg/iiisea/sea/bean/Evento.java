package br.ufg.iiisea.sea.bean;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by fellipe on 14/09/16.
 */
public class Evento {

    private String nome;
    private String descricao;
    private Date data_inicio;
    private Date data_fim;

    public Evento(String nome, String descricao, Date data_inicio, Date data_fim) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }
}
