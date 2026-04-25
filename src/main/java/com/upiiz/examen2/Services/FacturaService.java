package com.upiiz.examen2.Services;

import com.upiiz.examen2.entities.Factura;
import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.repositories.FacturaRepository;
import com.upiiz.examen2.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private VentaRepository ventaRepository;

    public List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }

    // Este es el método que te falta para el controlador
    public Factura buscarPorId(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }
    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);

    }

}