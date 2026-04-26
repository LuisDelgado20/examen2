package com.upiiz.examen2.Controllers;

import com.upiiz.examen2.Services.ProductoService;
import com.upiiz.examen2.Services.VentaService;
import com.upiiz.examen2.Services.CuentaService; // Asumiendo que es para "Usuarios"
import com.upiiz.examen2.entities.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private VentaService ventaService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/dashboard")
    public String index(Model model) {
        List<Venta> listaDeVentas = ventaService.listarTodas();

        // Creamos un arreglo de 12 posiciones (una por mes) inicializado en 0.0
        Double[] montosPorMes = new Double[12];
        Arrays.fill(montosPorMes, 0.0);

        for (Venta venta : listaDeVentas) {
            // Suponiendo que tu entidad Venta tiene un campo 'fecha' (LocalDate o Date)
            // Obtenemos el mes (1-12) y restamos 1 para el índice del arreglo (0-11)
            int mes = venta.getFechaVenta().getMonthValue() - 1;
            montosPorMes[mes] += venta.getTotal().doubleValue();
        }

        model.addAttribute("datosGrafica", montosPorMes);
        // ... resto de tus atributos
        return "dashboard/index";
    }
}