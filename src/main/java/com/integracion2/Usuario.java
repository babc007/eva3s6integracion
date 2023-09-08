package com.integracion2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "rut")
    private String rut;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    // Constructor
    public Usuario(String rut, String username, String password) {
        this.rut = rut;
        this.username = username;
        this.password = password;
    }

    // Getters y Setters
    public String getRut() {
        return rut;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
