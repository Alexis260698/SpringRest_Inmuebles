package com.example.SpringRestDto.controller;

import com.example.SpringRestDto.configuration.Exceptions.Cliente.ClienteExistenteException;
import com.example.SpringRestDto.configuration.Exceptions.Cliente.ClienteNotFoundException;
import com.example.SpringRestDto.configuration.Exceptions.Inmueble.InmuebleExistenteException;
import com.example.SpringRestDto.configuration.Exceptions.Inmueble.InmuebleNotFoundException;
import com.example.SpringRestDto.dto.ClienteDto;
import com.example.SpringRestDto.dto.InmuebleDto;
import com.example.SpringRestDto.entity.Cliente;
import com.example.SpringRestDto.entity.Inmueble;
import com.example.SpringRestDto.repository.InmuebleRepository;
import com.example.SpringRestDto.repository.SistemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InmuebleController {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/buscarInmueble/{codigo}")
    public ResponseEntity<InmuebleDto> buscarInmueble(@PathVariable("codigo") Integer codigo) throws InmuebleNotFoundException {
        Optional<Inmueble> optionalInmueble = inmuebleRepository.buscarInmueble(codigo);
        if (optionalInmueble.isPresent()) {
            InmuebleDto inmuebleDto = modelMapper.map(optionalInmueble.get(), InmuebleDto.class);
            return ResponseEntity.ok(inmuebleDto);
        } else {
            throw new InmuebleNotFoundException();
        }
    }

    @PostMapping("/crearInmueble")
    public ResponseEntity<InmuebleDto> CrearInmueble(@RequestBody InmuebleDto inmuebleDto) throws InmuebleExistenteException {
        Optional<Inmueble> existeInmueble = inmuebleRepository.buscarInmueble(inmuebleDto.getCodigo());

        if (existeInmueble.isPresent()) {
            throw new InmuebleExistenteException();
        }

        Inmueble inmueble= modelMapper.map(inmuebleDto, Inmueble.class);
        sistemaRepository.getListaInmuebles().add(inmueble);
        return ResponseEntity.ok(inmuebleDto);
    }

    @DeleteMapping("/eliminarInmueble/{codigo}")
    public ResponseEntity<InmuebleDto> eliminarInmueble(@PathVariable("codigo") Integer codigo) throws InmuebleNotFoundException{
        Optional<Inmueble> existeInmueble=inmuebleRepository.buscarInmueble(codigo);
        if (existeInmueble.isEmpty()) {
            throw new InmuebleNotFoundException();
        }

        InmuebleDto inmuebleDto = modelMapper.map(existeInmueble.get(), InmuebleDto.class);
        inmuebleRepository.eliminarInmueble(codigo);
        return ResponseEntity.ok(inmuebleDto);
    }

    @PutMapping("/actualizarInmueble")
    public ResponseEntity<InmuebleDto> actualizarInmueble(@RequestBody InmuebleDto inmuebleDto) throws InmuebleNotFoundException{
        Optional<Inmueble> existeInmueble= inmuebleRepository.buscarInmueble(inmuebleDto.getCodigo());

        if(existeInmueble.isEmpty()){
            throw new InmuebleNotFoundException();
        }

        Inmueble inmuebleNuevo= modelMapper.map(inmuebleDto,Inmueble.class);
        inmuebleRepository.actualizarInmueble(inmuebleNuevo);

        return ResponseEntity.ok(inmuebleDto);
    }
}
