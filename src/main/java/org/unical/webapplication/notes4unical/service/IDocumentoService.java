package org.unical.webapplication.notes4unical.service;

import java.util.Collection;

import org.unical.webapplication.notes4unical.model.Documento;

public interface IDocumentoService {
    Collection<Documento> findAll();
    Collection<Documento> findByMateria(String materia);
    Documento findById(int id);
    Documento createDocumento(Documento documento) throws Exception;
    void deleteDocumento(int id) throws Exception;

    
}
