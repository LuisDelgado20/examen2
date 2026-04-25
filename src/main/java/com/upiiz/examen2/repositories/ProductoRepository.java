package com.upiiz.examen2.repositories;

import com.upiiz.examen2.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Puedes agregar búsquedas personalizadas después, por ejemplo:
    List<Producto> findByCategoria(String categoria);
}