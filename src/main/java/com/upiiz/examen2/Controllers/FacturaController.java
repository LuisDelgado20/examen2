package com.upiiz.examen2.Controllers;

import com.upiiz.examen2.Services.VentaProductoService;
import com.upiiz.examen2.Services.VentaService;
import com.upiiz.examen2.entities.Factura;
import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.entities.VentaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private VentaService ventaService;
    @Autowired
    private VentaProductoService ventaProductoService;

//    @GetMapping("/factura/{id}")
//    public String verDetalle(@PathVariable Long id, Model model) {
//        Venta venta = ventaService.buscarPorId(id);
//
//        if (venta != null) {
//            Factura factura = new Factura();
//            factura.setVenta(venta);
//            factura.setTotal(venta.getTotal());
//            factura.setFechaEmision(LocalDate.now()); // Fecha de hoy: 25/04/2026
//
//            // Recuperamos los productos desde la tabla venta_productos
//            List<VentaProducto> listaDetalles = ventaProductoService.buscarPorVenta(venta);
//
//            model.addAttribute("detalles", listaDetalles);
//            model.addAttribute("factura", factura);
//            model.addAttribute("venta", venta);
//
//            return "facturas/detalle";
//        }
//        return "redirect:/facturas/listado";
//    }

    @GetMapping("/listado")
    public String listarFacturas(Model model) {
        // Obtenemos todas las ventas para mostrar el histórico de facturación
        model.addAttribute("ventas", ventaService.listarTodas());
        model.addAttribute("usuarioLogueado", "Luis");
        return "facturas/listado";
    }
    @GetMapping("/factura/{id}")
    public String mostrarFactura(@PathVariable Long id, Model model) {
        Venta venta = ventaService.buscarPorId(id);
        if (venta != null) {
            // Obtenemos los detalles específicos de esta venta
            List<VentaProducto> detalles = ventaProductoService.buscarPorVenta(venta);
            System.out.println("Detalles encontrados: " + detalles.size());

            model.addAttribute("venta", venta);
            // Enviamos la lista bajo el nombre "detalles" para que el HTML la use
            model.addAttribute("detalles", detalles);

            return "facturas/detalle";
        }
        return "redirect:/ventas/listado";
    }

}