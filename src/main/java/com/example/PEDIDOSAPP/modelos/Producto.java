package com.example.PEDIDOSAPP.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Producto")
    private Integer id;

//    @Column()
//    private  Integer idRestaurante;
    @Column(length = 100,nullable = false)
    private String nombre;
    @Column(length = 10,nullable = false)
    private double precio;
    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "fk_tienda",referencedColumnName = "id_tienda")
    @JsonBackReference
    private Tienda tienda;

    @ManyToOne
    @JsonBackReference
    private Detalle detalle;

    public Producto() {
    }

    public Producto(Integer id, String nombre, double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
