package org.unical.webapplication.notes4unical.persistence.dao.impljdbc;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.unical.webapplication.notes4unical.model.Documento;
import org.unical.webapplication.notes4unical.persistence.DBManager;
import org.unical.webapplication.notes4unical.persistence.dao.DocumentoDao;

@Repository
@Component
public class DocumentoDaoJDBCComponent implements DocumentoDao {

    Connection connection;

    public DocumentoDaoJDBCComponent(){
        this.connection = DBManager.getInstance().getConnection();
    }

    @Override
    public List<Documento> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Documento findByPrimarykey(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Documento> findByMateria(String materia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
