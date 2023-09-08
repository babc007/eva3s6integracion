package com.integracion2;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @Column(name = "rut")
    private String rut;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    // Constructor
    public Persona(String rut, String nombre, String apellido, String telefono, Date fechaIngreso) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    public Persona() {
		// TODO Auto-generated constructor stub
	}

	// Getters y Setters
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

	public void setRut(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setNombre(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setApellido(String string) {
		// TODO Auto-generated method stub
		
	}
}
