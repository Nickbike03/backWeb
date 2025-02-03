package org.unical.webapplication.notes4unical.service;

import org.springframework.stereotype.Service;
import org.unical.webapplication.notes4unical.model.Utente;
import org.unical.webapplication.notes4unical.persistence.dao.UtenteDao;

@Service
public class UtenteService implements IUtenteService {
    private UtenteDao utenteDao;

    public UtenteService(UtenteDao _utenteDao) { this.utenteDao = _utenteDao;}

    @Override
    public Utente findByEmail(String email) {
        return utenteDao.findByEmail(email);
    }

    @Override
    public Utente createUtente(Utente utente) throws Exception{
        Utente u = utenteDao.findByEmail(utente.getEmail());
        if ( u != null) {throw  new Exception("esiste gia un utente con questa email: "+utente.getEmail());}
        utenteDao.save(utente);
        return utenteDao.findByEmail(utente.getEmail());
    }

    @Override
    public void deleteUtente(String email) throws Exception{
        if (utenteDao.findByEmail(email) == null) throw new Exception("non esiste un utente da eliminare con la email: "+ email);
        utenteDao.delete(utenteDao.findByEmail(email));
    }



    
    
}
