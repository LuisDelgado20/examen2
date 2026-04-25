package com.upiiz.examen2.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // EL NOMBRE DEBE SER EXACTAMENTE ESTE
    @Column(name = "nombre_producto")
    private String nombreProducto;

    private BigDecimal precio;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private String categoria;

    // CONSTRUCTORES
    public Producto() {}

    // GETTERS Y SETTERS (Cruciales para el error 500)
    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getCantidadStock() { return cantidadStock; }
    public void setCantidadStock(Integer cantidadStock) { this.cantidadStock = cantidadStock; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}