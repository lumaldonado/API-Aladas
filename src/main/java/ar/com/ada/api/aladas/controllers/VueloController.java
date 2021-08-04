package ar.com.ada.api.aladas.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ar.com.ada.api.aladas.services.VueloService;

@RestController
public class VueloController {

    @Autowired
    VueloService service;
    
}
