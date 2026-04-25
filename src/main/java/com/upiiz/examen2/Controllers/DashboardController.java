package com.upiiz.examen2.Controllers;

import com.upiiz.examen2.Services.ProductoService;
import com.upiiz.examen2.Services.VentaService;
import com.upiiz.examen2.Services.CuentaService; // Asumiendo que es para "Usuarios"
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        // Datos para los cuadros superiores (Widgets)
        model.addAttribute("totalVentasCount", ventaService.listarTodas().size());
        model.addAttribute("totalProductosCount", productoService.obtenerTodos().size());
        model.addAttribute("totalUsuariosCount", cuentaService.obtenerTodas().size());

        // Datos para la gráfica (Ejemplo manual, puedes automatizarlo después)
        // Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio
        int[] datosVentas = {25, 45, 30, 15, 85, 25, 95};
        model.addAttribute("datosGrafica", datosVentas);

        return "dashboard/index";
    }
}