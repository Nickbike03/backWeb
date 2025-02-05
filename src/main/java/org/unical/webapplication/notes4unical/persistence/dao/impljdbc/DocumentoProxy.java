package org.unical.webapplication.notes4unical.persistence.dao.impljdbc;

import org.unical.webapplication.notes4unical.model.Documento;
import org.unical.webapplication.notes4unical.persistence.dao.DocumentoDao;

public class DocumentoProxy extends Documento {
    private boolean contenutoCaricato = false;
    private DocumentoDao documentoDao;

    public DocumentoProxy(int id, String utente, String nome, String descrizione, String materia, DocumentoDao documentoDao) {
        super(id, utente, nome, descrizione, materia, null);
        this.documentoDao = documentoDao;
    }

    @Override
    public byte[] getContenuto() {
        if (!contenutoCaricato) {
            Documento documentoReale = documentoDao.findByPrimarykey(this.getId());
            if (documentoReale != null) {
                super.setContenuto(documentoReale.getContenuto());
            }
            contenutoCaricato = true;
        }
        return super.getContenuto();
    }
}
