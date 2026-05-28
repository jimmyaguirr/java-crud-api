package com.jimmy.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(schema = "security",name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @Column(name="person_id")
    private UUID personId;

    @Column(name="role_id")
    private UUID roleId;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;
}
