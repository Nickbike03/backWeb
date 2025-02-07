package org.unical.webapplication.notes4unical.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.unical.webapplication.notes4unical.model.Documento;
import org.unical.webapplication.notes4unical.service.IDocumentoService;

@RequestMapping("/api/documento")
@RestController
public class DocumentoController {

    private final IDocumentoService documentoService;

    public DocumentoController(IDocumentoService _documentoService){
        this.documentoService = _documentoService;
    }


    @RequestMapping(value = "/getAllDocumenti", method = RequestMethod.GET)
    ResponseEntity<Collection<Documento>> getAllDocumenti(){
        Collection<Documento> all = this.documentoService.findAll();
        return  ResponseEntity.ok(all);
    }

    @RequestMapping(value= "/{docId}", method= RequestMethod.GET)
    ResponseEntity<Documento> getDocumentoById(@PathVariable int docId){
        return ResponseEntity.ok(this.documentoService.findById(docId));
    }

    @RequestMapping(value= "/{materia}", method= RequestMethod.GET)
    ResponseEntity<Collection<Documento>> getDocumentoByMateria(@PathVariable String materia){
        return ResponseEntity.ok(this.documentoService.findByMateria(materia));
    }

    @RequestMapping(value="", method= RequestMethod.POST)
    ResponseEntity<Documento> createNewDocumento(@RequestBody Documento documento) throws Exception{
        try {
            return ResponseEntity.ok(this.documentoService.createDocumento(documento));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        }
    }

    @RequestMapping(value = "/{docId}", method= RequestMethod.DELETE)
    ResponseEntity<Void> deleteDocumento (int docId) throws Exception{
        try {
            this.documentoService.deleteDocumento(docId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
    }


    
}
