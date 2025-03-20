package com.example.PEDIDOSAPP.modelos;

import com.example.PEDIDOSAPP.ayudas.enums.PedidoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

//    private Integer idUsuario;
//    private Integer idRestaurante;

    private PedidoEnum estado;
    private LocalDate fechaPedido;
    @Column(length = 10,nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "fk_usuario",referencedColumnName = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_tienda",referencedColumnName = "id_tienda")
    @JsonBackReference
    private Tienda tienda;

    @ManyToOne
    @JsonBackReference
    private Pago pago;

    @ManyToOne
    @JsonBackReference
    private Detalle detalle;

    @ManyToOne
    @JsonManagedReference
    private Entrega entrega;





    public Pedido() {
    }

    public Pedido(Integer id, PedidoEnum estado, LocalDate fechaPedido, double total) {
        this.id = id;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PedidoEnum getEstado() {
        return estado;
    }

    public void setEstado(PedidoEnum estado) {
        this.estado = estado;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
