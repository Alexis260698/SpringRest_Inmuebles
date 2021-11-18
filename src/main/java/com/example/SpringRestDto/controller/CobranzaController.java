package com.example.SpringRestDto.controller;

import com.example.SpringRestDto.configuration.Exceptions.Cobranza.CobranzaExistente;
import com.example.SpringRestDto.configuration.Exceptions.Cobranza.CrearCobranzaException;
import com.example.SpringRestDto.entity.Cobranza;
import com.example.SpringRestDto.repository.CobranzaRepository;
import com.example.SpringRestDto.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class CobranzaController {
/*
    @Autowired
    private CobranzaRepository cobranzaRepository;

    @Autowired
    private SistemaRepository sistemaRepository;

    @PostMapping("/crearCobranza")
    public void crearCobranza(@RequestBody Cobranza cobranza) throws CrearCobranzaException, CobranzaExistente {

        Optional<Cobranza> existeCobranza= cobranzaRepository.buscarCobranza(cobranza.getNumero());


        if(existeCobranza.isPresent()){
            throw new CobranzaExistente();
        }

        try {
            cobranzaRepository.addCobranza(cobranza);

        }catch (Exception e){
            throw new CrearCobranzaException();
        }
    }



 */

}
