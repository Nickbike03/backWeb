package org.unical.webapplication.notes4unical.model;

import java.util.Date;

public class CorsoDiStudio {
    protected int id;
    protected String nome;
    protected String facoltà;
    protected Date data;

    
    public CorsoDiStudio() {
    }

    
    public CorsoDiStudio(int id, String nome, String facoltà, Date data) {
        this.id = id;
        this.nome = nome;
        this.facoltà = facoltà;
        this.data = data;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFacoltà() {
        return facoltà;
    }
    public void setFacoltà(String facoltà) {
        this.facoltà = facoltà;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    
    
}
