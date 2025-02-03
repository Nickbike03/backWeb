package org.unical.webapplication.notes4unical.persistence.dao;

import java.util.List;

import org.unical.webapplication.notes4unical.model.CorsoDiStudio;

public interface CorsoDiStudioDao {
    public List<CorsoDiStudio> findAll();
    public CorsoDiStudio findByPrimaryKey (int id);
    public void save(CorsoDiStudio corsoDiStudio);
    public void delete (CorsoDiStudio corsoDiStudio);    
}
