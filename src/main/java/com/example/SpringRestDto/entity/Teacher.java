package com.example.SpringRestDto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Profesores")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String direccion;
    private Integer edad;

    @ElementCollection @Column(name= "CourseList")
    private List<Course> courseList;
}
