package com.upiiz.examen2.Services;

import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.entities.VentaProducto;
import com.upiiz.examen2.repositories.VentaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaProductoService {
    @Autowired
    private VentaProductoRepository repository;

    public void guardar(VentaProducto vp) { repository.save(vp); }
    public List<VentaProducto> buscarPorVenta(Venta v) { return repository.findByVenta(v); }
}