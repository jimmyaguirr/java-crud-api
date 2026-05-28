package com.jimmy.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(schema = "security",name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="nit")
    private Integer nit;

    @Column(name="type_nit")
    private Integer typeNit;

    @Column(name="age")
    private Integer age;

}
