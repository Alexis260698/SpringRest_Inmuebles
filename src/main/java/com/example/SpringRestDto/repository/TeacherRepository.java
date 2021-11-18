package com.example.SpringRestDto.repository;

import com.example.SpringRestDto.entity.Cliente;
import com.example.SpringRestDto.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    public List<Teacher> findTeacherByNombreAndEdad(String nombre, Integer edad);

    @Query(value = "Select * from profesores where nombre=:nombre and edad=:edad", nativeQuery = true)
    public List<Teacher> findTeacherByNombreAndEdadPorQueryNativa (String nombre, Integer edad);

    @Query(value = "Select * from Teacher t where t.nombre=:?1 and t.edad=:?2")
    public List<Teacher> findTeacherByNombreAndEdadPorJPQL (String nombre, Integer edad);



}
