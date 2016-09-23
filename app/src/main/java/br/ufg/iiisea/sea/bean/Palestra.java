package br.ufg.iiisea.sea.bean;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by fellipe on 14/09/16.
 */
public class Palestra {
    public enum Tipo {

    }

    private String nome;
    private String descricao;
    private Sala sala;
    private Programacao programacao;
    private Date hora_inicio;
    private Date hora_fim;
//    private ArrayList<Palestrante> palestrantes;
    private Tipo tipo;

}
