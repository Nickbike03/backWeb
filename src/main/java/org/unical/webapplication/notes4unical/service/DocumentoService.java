package org.unical.webapplication.notes4unical.service;

import java.util.Collection;

import org.unical.webapplication.notes4unical.model.Documento;
import org.unical.webapplication.notes4unical.persistence.dao.DocumentoDao;

public class DocumentoService implements IDocumentoService {

    private final DocumentoDao documentoDao;

    DocumentoService(DocumentoDao _documentoDao){
        this.documentoDao = _documentoDao;
    }

    @Override
    public Collection<Documento> findAll() {
        return documentoDao.findAll();
    }

    @Override
    public Collection<Documento> findByMateria(String materia) {
        return documentoDao.findByMateria(materia);
    }

    @Override
    public Documento findById(int id) {
        return documentoDao.findByPrimarykey(id);
    }

    @Override
    public Documento createDocumento(Documento documento) throws Exception {
        Documento d = documentoDao.findByPrimarykey(documento.getId());
        if (d != null) throw new Exception("esiste gia un altro documento con id: "+ d.getId());
        
        return documentoDao.findByPrimarykey(documento.getId());
    }

    @Override
    public void deleteDocumento(int id) throws Exception {
        Documento d = documentoDao.findByPrimarykey(id);
        if (d == null) throw new Exception("non esiste un documento che ha id: " + id);
    }

   
    
}
