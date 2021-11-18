package com.example.SpringRestDto.repository;

import com.example.SpringRestDto.entity.Cliente;
import com.example.SpringRestDto.entity.Cobranza;
import com.example.SpringRestDto.entity.Inmueble;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter @Setter
public class SistemaRepository {
    @Autowired
    private ClienteRepositoryDao clienteRepositoryDao;



    private List<Cliente> listaClientes= new ArrayList<>();
    private List<Cobranza> listaCobranzas= new ArrayList<>();
    private List<Inmueble> listaInmuebles= new ArrayList<>();
}
