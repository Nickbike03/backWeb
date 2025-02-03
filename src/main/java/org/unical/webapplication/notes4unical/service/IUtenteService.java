package org.unical.webapplication.notes4unical.service;

import org.unical.webapplication.notes4unical.model.Utente;

public interface IUtenteService {
    Utente findByEmail(String email);
    Utente createUtente (Utente utente);
    void deleteUtente(String email);

}
