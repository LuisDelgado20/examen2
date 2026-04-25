package com.upiiz.examen2.Services;

import com.upiiz.examen2.entities.Producto;
import com.upiiz.examen2.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("productoServiceBean")
public class ProductoService {


    @Autowired
    private ProductoRepository productoRepository;

    // DEJA SOLO ESTE NOMBRE
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
    
}