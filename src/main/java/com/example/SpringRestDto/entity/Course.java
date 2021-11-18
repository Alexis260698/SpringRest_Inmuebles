package com.example.SpringRestDto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Cursos")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

