package com.example.SpringRestDto.repository;

import com.example.SpringRestDto.entity.Cliente;
import com.example.SpringRestDto.entity.Teacher;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Getter
@Setter
public class ClienteRepository {

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private ClienteRepositoryDao clienteRepositoryDao;

    @Autowired
    private TeacherRepository teacherRepository;

    public void CrearCliente(Cliente cliente) {
        clienteRepositoryDao.save(cliente);
    }

    public List<Cliente> getClientes(){
        return (List<Cliente>) clienteRepositoryDao.findAll();
    }

    public List<Teacher> getTeachersbyNameAndAge(String nombre, Integer edad) {
    return teacherRepository.findTeacherByNombreAndEdad(nombre, edad);
    }


/*
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
*/

}
