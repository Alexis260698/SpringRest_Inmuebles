package com.example.SpringRestDto.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Sistema {
    private List<Cliente> listaClientes;
    private List<Cobranza> listaCobranzas;
    private List<Inmueble> listaInmuebles;


}
