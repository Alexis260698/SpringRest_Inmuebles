package com.example.SpringRestDto.dto;

import com.example.SpringRestDto.entity.Cliente;
import com.example.SpringRestDto.entity.Inmueble;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CobranzaDto {
    private Integer numero;
    private String fecha;
    private Cliente cliente;
    private Inmueble inmueble;


}
