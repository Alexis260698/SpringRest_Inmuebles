package com.example.SpringRestDto.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cobranza {
    private Integer numero;
    private String fecha;
    private Cliente cliente;
    private Inmueble inmueble;

    public Cobranza(Integer numero, String fecha, Cliente cliente, Inmueble inmueble) {
        this.numero= numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.inmueble = inmueble;
    }
}
