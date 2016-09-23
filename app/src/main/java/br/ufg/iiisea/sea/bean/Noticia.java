package br.ufg.iiisea.sea.bean;

import java.util.Date;

/**
 * Created by fellipe on 22/09/16.
 */
public class Noticia {

    private int id;
    private String titulo;
    private Date data;
    private String conteudo;
    private Evento evento;

    public Noticia() {

    }

    public Noticia(int id, String titulo, Date data, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
