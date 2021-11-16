package com.example.SpringRestDto.controller;

import com.example.SpringRestDto.configuration.Exceptions.Cliente.ClienteExistenteException;
import com.example.SpringRestDto.configuration.Exceptions.Cliente.ClienteNotFoundException;
import com.example.SpringRestDto.dto.ClienteDto;
import com.example.SpringRestDto.entity.Cliente;
import com.example.SpringRestDto.repository.ClienteRepository;
import com.example.SpringRestDto.repository.SistemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClienteController() {
    }

    @GetMapping("/buscarCliente/{dni}")
    public ResponseEntity<ClienteDto> buscarCliente(@PathVariable("dni") String dni) throws ClienteNotFoundException {
        Optional<Cliente> optionalCliente = clienteRepository.buscarCliente(dni);
        if (optionalCliente.isPresent()) {
            ClienteDto clienteDto = modelMapper.map(optionalCliente.get(), ClienteDto.class);
            return ResponseEntity.ok(clienteDto);
        } else {
            throw new ClienteNotFoundException();
        }
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<ClienteDto> CrearCliente(@RequestBody ClienteDto clienteDto) throws ClienteExistenteException {
        Optional<Cliente> existeCliente = clienteRepository.buscarCliente(clienteDto.getDni());

        if (existeCliente.isPresent()) {
            throw new ClienteExistenteException();
        }

        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        sistemaRepository.getListaClientes().add(cliente);
        return ResponseEntity.ok(clienteDto);
    }

    @DeleteMapping("/eliminarCliente/{dni}")
    public ResponseEntity<ClienteDto> eliminarCliente(@PathVariable("dni") String dni) throws ClienteNotFoundException{
        Optional<Cliente> existeCliente=clienteRepository.buscarCliente(dni);
        if (existeCliente.isEmpty()) {
            throw new ClienteNotFoundException();
        }

        ClienteDto clienteDto = modelMapper.map(existeCliente.get(), ClienteDto.class);
        clienteRepository.eliminarCliente(dni);
        return ResponseEntity.ok(clienteDto);
    }

    @PutMapping("/actualizarCliente")
    public ResponseEntity<ClienteDto> actualizarCliente(@RequestBody ClienteDto clienteDto) throws ClienteNotFoundException{
        Optional<Cliente> existeCliente= clienteRepository.buscarCliente(clienteDto.getDni());

        if(existeCliente.isEmpty()){
            throw new ClienteNotFoundException();
        }

        Cliente clienteNuevo= modelMapper.map(clienteDto,Cliente.class);
        clienteRepository.actualizarCliente(clienteNuevo);

        return ResponseEntity.ok(clienteDto);
    }



}
