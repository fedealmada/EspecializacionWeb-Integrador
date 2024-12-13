package com.example.demo.model;

import com.example.demo.enums.Role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)

@NamedQueries({
    @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
})

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String apellido;

    String nombre;
    String email;
    String nacionalidad;
    String password;
    
    @Enumerated(EnumType.STRING) 
    Role role;
}