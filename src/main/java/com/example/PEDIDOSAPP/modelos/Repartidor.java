package com.example.PEDIDOSAPP.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Repartidor")
public class Repartidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repartidor")
    private Integer id;
    @Column(length = 100,nullable = false)
    private String nombre;
    @Column(length = 20,nullable = false)
    private String telefono;
    @Column(name = "email",length = 150,unique = true,nullable = false)
    private String correo;
    @Column(length = 50)
    private String vehiculo;

    @OneToMany(mappedBy = "repartidor")
    @JsonManagedReference
    private List<Entrega> entregas;

    public Repartidor() {
    }

    public Repartidor(Integer id, String nombre, String telefono, String correo, String vehiculo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.vehiculo = vehiculo;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
}
