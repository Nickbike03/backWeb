package org.unical.webapplication.notes4unical.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.unical.webapplication.notes4unical.model.CorsoDiStudio;
import org.unical.webapplication.notes4unical.persistence.dao.CorsoDiStudioDao;

@Service
public class CorsoDiStudioService implements ICorsoDiStusioService{

    private final CorsoDiStudioDao corsoDiStudioDao;

    CorsoDiStudioService(CorsoDiStudioDao _corsoDiStudioDao){
        this.corsoDiStudioDao = _corsoDiStudioDao;
    }

    @Override
    public Collection<CorsoDiStudio> findAll() {
       return corsoDiStudioDao.findAll();
    }

    @Override
    public CorsoDiStudio findById(int id) {
        return corsoDiStudioDao.findByPrimaryKey(id);
    }

    @Override
    public CorsoDiStudio createCorsoDiStudio(CorsoDiStudio c) throws Exception {
        CorsoDiStudio corsoDiStudio = corsoDiStudioDao.findByPrimaryKey(c.getId());
        if (corsoDiStudio != null){
            throw new Exception("Esiste gia un corso di studio con id: "+ corsoDiStudio.getId());
        }
        corsoDiStudioDao.save(c);
        return corsoDiStudioDao.findByPrimaryKey(c.getId());
    }

    @Override
    public void deleteCorsoDiStudio(CorsoDiStudio c) throws Exception {
        CorsoDiStudio corso = corsoDiStudioDao.findByPrimaryKey(c.getId());
        if (corso == null){
            throw new Exception("non esiste nessun corso di studio con id: "+ c.getId());
        }
        corsoDiStudioDao.delete(corso);
    }

    
    

    
}
