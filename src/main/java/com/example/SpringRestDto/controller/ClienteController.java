package com.example.SpringRestDto.controller;

import com.example.SpringRestDto.configuration.Exceptions.Cliente.ClienteExistenteException;
import com.example.SpringRestDto.configuration.Exceptions.Cliente.ClienteNotFoundException;
import com.example.SpringRestDto.dto.ClienteDto;
import com.example.SpringRestDto.entity.Cliente;
import com.example.SpringRestDto.entity.Teacher;
import com.example.SpringRestDto.repository.ClienteRepository;
import com.example.SpringRestDto.repository.SistemaRepository;
import com.example.SpringRestDto.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClienteController() {
    }
/*
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
*/

    @GetMapping("/traerTodos")
    public List<Cliente> getClientes(){
        return clienteRepository.getClientes();
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<Cliente> CrearCliente(@RequestBody Cliente cliente)  {
        clienteRepository.CrearCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/teacher/{nombre}/{edad}")
    public List<Teacher> getTeacherByNameyAge(@PathVariable("nombre") String nombre, @PathVariable("edad") Integer edad){
        return clienteRepository.getTeachersbyNameAndAge(nombre,edad);
    }

    @GetMapping("/teacherByQuery/{nombre}/{edad}")
    public List<Teacher> getTeacherByNameyAgeByQuery(@PathVariable("nombre") String nombre, @PathVariable("edad") Integer edad){
        return teacherRepository.findTeacherByNombreAndEdadPorQueryNativa(nombre,edad);
    }

    @GetMapping("/teacherByJPQL/{nombre}/{edad}")
    public List<Teacher> getTeacherByNameyAgeByJPQL(@PathVariable("nombre") String nombre, @PathVariable("edad") Integer edad){
        return teacherRepository.findTeacherByNombreAndEdadPorJPQL(nombre,edad);
    }



    /*
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

    @GetMapping("/traerTodos")
    public ResponseEntity<List<Cliente>> listaClientes(){
        return ResponseEntity.ok(sistemaRepository.getListaClientes());
    }
*/
}
