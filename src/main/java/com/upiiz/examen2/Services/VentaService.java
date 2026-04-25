package com.upiiz.examen2.Services;

import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> listarTodas() {
        return ventaRepository.findAll();
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta buscarPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }
    public List<Venta> obtenerTodas() {
        return ventaRepository.findAll();
    }
    public void eliminar(Long id) {
        ventaRepository.deleteById(id);
    }
}