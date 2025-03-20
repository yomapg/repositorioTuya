package com.example.PEDIDOSAPP.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.util.List;

@Entity
@Table(name = "DetallePedido")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer id;

//    private Integer idPedido;
//    private  Integer idProducto;
    @Column(nullable = false)
    private int cantidad;
    @Column(length = 10,nullable = false)
    private double subTotal;

    @OneToMany(mappedBy = "detalle")
    @JoinColumn(name = "fk_pedido",referencedColumnName = "id_pedido")
    @JsonManagedReference
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "detalle")
    @JoinColumn(name = "fk_producto",referencedColumnName = "id_producto")
    @JsonManagedReference
    private List<Producto> productos;

    public Detalle() {
    }

    public Detalle(Integer id, int cantidad, double subTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
