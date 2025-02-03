package org.unical.webapplication.notes4unical.model;

public class Utente {
    protected  String email;
    protected  String nome;
    protected  String cognome;
    protected  String pasword;
    protected  int CorsoDiStudio;
    //TODO aggiungere una lista di documenti che l'utente ha caricato

    public Utente() {}
    

    public Utente(String email, String nome, String cognome, String pasword, int corsoDiStudio) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.pasword = pasword;
        CorsoDiStudio = corsoDiStudio;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getPasword() {
        return pasword;
    }
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    public int getCorsoDiStudio() {
        return CorsoDiStudio;
    }
    public void setCorsoDiStudio(int corsoDiStudio) {
        CorsoDiStudio = corsoDiStudio;
    }

    @Override
    public String toString() {
        return "Utente [email=" + email + ", nome=" + nome + ", cognome=" + cognome + ", pasword=" + pasword
                + ", CorsoDiStudio=" + CorsoDiStudio + "]";
    }

    


}
