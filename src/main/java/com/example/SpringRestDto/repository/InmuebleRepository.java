package com.example.SpringRestDto.repository;

import com.example.SpringRestDto.entity.Inmueble;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Getter @Setter
public class InmuebleRepository {
/*
    @Autowired
    private SistemaRepository sistemaRepository;

    public void crearInmueble(Inmueble inmueble){
        sistemaRepository.getListaInmuebles().add(inmueble);
    }

    public Optional<Inmueble> buscarInmueble(Integer codigo){
        return sistemaRepository.getListaInmuebles().stream().filter(i ->i.getCodigo().equals(codigo)).findFirst();
    }

    public void eliminarInmueble(Integer codigo){
        sistemaRepository.getListaInmuebles().removeIf(i ->i.getCodigo().equals(codigo));
    }

    public void actualizarInmueble(Inmueble inmueble){
        for(Inmueble i:sistemaRepository.getListaInmuebles()){
            if(i.getCodigo().equals(inmueble.getCodigo())){
                i.setCodigo(inmueble.getCodigo());
                i.setDomicilio(inmueble.getDomicilio());
                i.setImporte(inmueble.getImporte());
            }
        }

    }

    */
}
