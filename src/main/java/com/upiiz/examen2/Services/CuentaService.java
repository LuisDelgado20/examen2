package com.upiiz.examen2.Services;

import com.upiiz.examen2.entities.Cuenta;
import com.upiiz.examen2.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> listarTodas() {
        return cuentaRepository.findAll();
    }

    public Cuenta guardar(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void eliminar(Long id) {
        cuentaRepository.deleteById(id);
    }

    public boolean validarCredenciales(String email, String password) {
        return cuentaRepository.findByEmailAndPassword(email, password).isPresent();
    }

    public Cuenta buscarPorEmail(String email) {
        return cuentaRepository.findByEmail(email).orElse(null);
    }

    public Cuenta buscarPorId(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }



    // CORRECCIÓN: Ahora maneja la lista que viene del repositorio
    public Cuenta buscarPorTitular(String titular) {
        List<Cuenta> cuentas = cuentaRepository.findByTitular(titular);
        // Si hay cuentas, devolvemos la primera para evitar que la vista falle
        return cuentas.isEmpty() ? null : cuentas.get(0);
    }
    // Agrega este método
    public List<Cuenta> obtenerTodas() {
        return cuentaRepository.findAll();
    }


    public Cuenta obtenerPorId(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }
}