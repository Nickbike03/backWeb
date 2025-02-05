package org.unical.webapplication.notes4unical.model;

public class Documento {
    protected int id;
    protected String utente;
    protected String nome;
    protected String destrizione;
    protected String materia;
    protected byte[] contenuto;

    public Documento() {}

    
   

    public Documento(int id, String utente, String nome, String destrizione, String materia, byte[] _contenuto) {
        this.id = id;
        this.utente = utente;
        this.nome = nome;
        this.destrizione = destrizione;
        this.materia = materia;
        this.contenuto = _contenuto;
    }




    public String getUtente() {
        return utente;
    }
    public void setUtente(String utente) {
        this.utente = utente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDestrizione() {
        return destrizione;
    }
    public void setDestrizione(String destrizione) {
        this.destrizione = destrizione;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public byte[] getContenuto() {
        return contenuto;
    }

    public void setContenuto(byte[] contenuto) {
        this.contenuto = contenuto;
    }





    
    
    
}
