package org.unical.webapplication.notes4unical.persistence.dao.impljdbc;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.unical.webapplication.notes4unical.model.Utente;
import org.unical.webapplication.notes4unical.persistence.DBManager;
import org.unical.webapplication.notes4unical.persistence.dao.UtenteDao;

@Component
@Repository
public class UtenteDaoJDBCComponent implements UtenteDao {

    Connection connection;


    public UtenteDaoJDBCComponent(){
        this.connection = DBManager.getInstance().getConnection();
    }


    @Override
    public List<Utente> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Utente findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Override
    public void save(Utente utente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Utente utente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
