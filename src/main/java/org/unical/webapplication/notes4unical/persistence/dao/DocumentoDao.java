package org.unical.webapplication.notes4unical.persistence.dao;

import java.util.List;

import org.unical.webapplication.notes4unical.model.Documento;

public interface DocumentoDao {
    public List<Documento> findAll();
    public Documento findByPrimarykey(int id);
    public void save(Documento documento );
    public void delete (Documento documento);

    public List<Documento> findByMateria(String materia);
    
}
