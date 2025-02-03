package org.unical.webapplication.notes4unical.service;

import java.util.Collection;

import org.unical.webapplication.notes4unical.model.CorsoDiStudio;

public interface ICorsoDiStusioService {
    Collection<CorsoDiStudio> findAll();
    CorsoDiStudio findById(int id);
    CorsoDiStudio createCorsoDiStudio(CorsoDiStudio c) throws Exception ;
    void deleteCorsoDiStudio(CorsoDiStudio c)throws Exception;
}
