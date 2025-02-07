package org.unical.webapplication.notes4unical.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unical.webapplication.notes4unical.model.Utente;
import org.unical.webapplication.notes4unical.service.IUtenteService;
import org.unical.webapplication.notes4unical.service.UtenteService;



@RequestMapping("/api/utente")
@Controller
public class UtenteController {
    private final IUtenteService utenteService;

    public UtenteController(UtenteService _utenteService){
        this.utenteService = _utenteService;
    }


    @RequestMapping(value= "{email}", method=RequestMethod.GET)   
    ResponseEntity<Utente> getUtenteByEmail(@PathVariable String _email){
        return ResponseEntity.ok(this.utenteService.findByEmail(_email));
    }
    
}
