package com.example.SpringRestDto.repository;

import com.example.SpringRestDto.entity.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Getter
@Setter
public class ClienteRepository {

    @Autowired
    private SistemaRepository sistemaRepository;

    public void CrearCliente(Cliente cliente) {
        sistemaRepository.getListaClientes().add(cliente);
    }

    public void eliminarCliente(String dni) {
        sistemaRepository.getListaClientes().removeIf(cliente -> cliente.getDni().equals(dni));
    }

    public Optional<Cliente> buscarCliente(String dni) {
        return sistemaRepository.getListaClientes().stream().filter(c -> c.getDni().equals(dni)).findFirst();
    }

    public void actualizarCliente(Cliente c) {
        for (Cliente cliente : sistemaRepository.getListaClientes()) {
            if (cliente.getDni().equals(c.getDni())) {
                cliente.setDni(c.getDni());
                cliente.setNombre(c.getNombre());
            }
        }
    }


}
