package org.unical.webapplication.notes4unical.persistence.dao;

import java.util.List;

import org.unical.webapplication.notes4unical.model.Utente;

public interface UtenteDao {
    public List<Utente> findAll();
    public Utente findByPrimarykey (int id);
    public void save(Utente utente);
    public void delete (Utente utente);

    //List<Utente> findByUtenteName(String name);
}
