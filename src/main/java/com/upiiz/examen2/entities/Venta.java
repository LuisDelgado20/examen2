package com.upiiz.examen2.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    private BigDecimal total;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta = LocalDateTime.now();

    private String estado;

    // Relación para el desglose de productos
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VentaDetalle> detalles = new ArrayList<>();

    // 1. CONSTRUCTOR VACÍO (Obligatorio para evitar el error "no arguments")
    public Venta() {}

    // 2. CONSTRUCTOR COMPLETO (Actualizado con la lista de detalles)
    public Venta(Long id, String nombreCliente, BigDecimal total, LocalDateTime fechaVenta, String estado, List<VentaDetalle> detalles) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.total = total;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.detalles = detalles;
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public LocalDateTime getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDateTime fechaVenta) { this.fechaVenta = fechaVenta; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<VentaDetalle> getDetalles() { return detalles; }
    public void setDetalles(List<VentaDetalle> detalles) { this.detalles = detalles; }
}