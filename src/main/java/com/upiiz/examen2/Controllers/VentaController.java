package com.upiiz.examen2.Controllers;

import com.upiiz.examen2.Services.FacturaService;
import com.upiiz.examen2.Services.ProductoService;
import com.upiiz.examen2.Services.VentaProductoService;
import com.upiiz.examen2.Services.VentaService;
import com.upiiz.examen2.entities.Factura;
import com.upiiz.examen2.entities.Producto;
import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.entities.VentaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private VentaService ventaService;
    @Autowired
    private FacturaService facturaService;
    @Autowired
    private VentaProductoService ventaProductoService;



    @GetMapping("/agregar-producto/{id}")
    public String mostrarFormularioAgregarProducto(@PathVariable("id") Long id, Model model) {
        // Usa los nuevos nombres de variable
        Venta venta = ventaService.buscarPorId(id);
        List<Producto> productos = productoService.obtenerTodos();

        model.addAttribute("venta", venta);
        model.addAttribute("productos", productos);
        model.addAttribute("usuarioLogueado", "Luis");
        return "ventas/agregar-producto";
    }

    @GetMapping("")
    public String listarVentas(Model model) {
        model.addAttribute("ventas", ventaService.listarTodas());
        model.addAttribute("usuarioLogueado", "Luis");
        return "ventas/listado";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("usuarioLogueado", "Luis");
        return "ventas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute("venta") Venta venta) {
        ventaService.guardar(venta);
        return "redirect:/ventas";
    }
    @PostMapping("/guardar-detalle")
    public String guardarDetalle(@RequestParam("ventaId") Long ventaId,
                                 @RequestParam("productoId") Long productoId,
                                 @RequestParam("cantidad") Integer cantidad) {

        System.out.println("VENTA ID: " + ventaId);
        System.out.println("PRODUCTO ID: " + productoId);
        System.out.println("CANTIDAD: " + cantidad);


        Venta venta = ventaService.buscarPorId(ventaId);
        Producto producto = productoService.buscarPorId(productoId);

        // DENTRO DE TU MÉTODO PARA AGREGAR PRODUCTOS
        // Dentro de tu método en VentaController
        if (venta != null && producto != null) {

            // 1. DECLARA 'totalActual' (Obtenemos el total que ya tiene la venta o 0 si es nueva)
            BigDecimal totalActual = (venta.getTotal() != null) ? venta.getTotal() : BigDecimal.ZERO;

            // 2. DECLARA Y CALCULA 'subtotal'
            // precio proviene de producto.getPrecio() y cantidad de tu parámetro
            BigDecimal subtotal = producto.getPrecio().multiply(new BigDecimal(cantidad));

            // Ahora ya puedes usar las variables sin error
            VentaProducto detalle = new VentaProducto();
            detalle.setVenta(venta);
            detalle.setProducto(producto);
            detalle.setCantidad(cantidad.intValue());
            detalle.setPrecioUnitario(producto.getPrecio());

            // Guardamos el detalle en la tabla intermedia
            ventaProductoService.guardar(detalle);

            // 3. ACTUALIZAMOS EL TOTAL USANDO LAS VARIABLES DECLARADAS
            venta.setTotal(totalActual.add(subtotal));
            ventaService.guardar(venta);
        }
        return "redirect:/ventas";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        ventaService.eliminar(id);
        return "redirect:/ventas";
    }

}