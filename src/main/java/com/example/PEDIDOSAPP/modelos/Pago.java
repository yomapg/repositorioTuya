package com.example.PEDIDOSAPP.modelos;

import com.example.PEDIDOSAPP.ayudas.enums.PagoEnum;
import com.example.PEDIDOSAPP.ayudas.enums.PagoEstadoEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id;

//    private Integer idPedido;

    @Column()
    private PagoEnum metodoPago;
    @Column()
    private PagoEstadoEnum estado;
    @Column()
    private LocalDate fechaPago;

    @OneToMany(mappedBy = "pago")
    @JoinColumn(name = "fk_pedido",referencedColumnName = "id_pedido")
    @JsonManagedReference
    private List<Pedido> pedidos;

    public Pago() {
    }

    public Pago(Integer id, Integer idPedido, PagoEnum metodoPago, PagoEstadoEnum estado, LocalDate fechaPago) {
        this.id = id;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.fechaPago = fechaPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PagoEnum getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(PagoEnum metodoPago) {
        this.metodoPago = metodoPago;
    }

    public PagoEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(PagoEstadoEnum estado) {
        this.estado = estado;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
