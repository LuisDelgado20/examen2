package com.upiiz.examen2.repositories;

import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.entities.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaProductoRepository extends JpaRepository<VentaProducto, Long> {
    List<VentaProducto> findByVenta(Venta venta);
}