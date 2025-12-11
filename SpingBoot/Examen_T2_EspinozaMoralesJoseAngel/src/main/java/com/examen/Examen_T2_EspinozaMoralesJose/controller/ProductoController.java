package com.examen.Examen_T2_EspinozaMoralesJose.controller;

import com.examen.Examen_T2_EspinozaMoralesJose.Model.Producto;
import com.examen.Examen_T2_EspinozaMoralesJose.service.CategoriaService;
import com.examen.Examen_T2_EspinozaMoralesJose.service.ProductoService;
import com.examen.Examen_T2_EspinozaMoralesJose.service.ProveedorService;
import com.examen.Examen_T2_EspinozaMoralesJose.utils.Alert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;
    private final ProveedorService proveedorService;

    private void cargarCombos(Model model) {
        model.addAttribute("categoria", categoriaService.listarCategoria());
        model.addAttribute("proveedor", proveedorService.listaProveedor());
        model.addAttribute("lista", productoService.listaProducto());
    }

    @GetMapping
    public String listarProductos(Model model) {
        cargarCombos(model);
        model.addAttribute("producto", new Producto());
        return "ViewCrud";
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable String id, Model model) {
        productoService.filtrarProducto(id).ifPresentOrElse(
                producto -> {
                    model.addAttribute("producto", producto);
                    cargarCombos(model);
                },
                () -> model.addAttribute("alerta", Alert.sweetAlertError("Producto no encontrado"))
        );
        return "ViewCrud";
    }

    @PostMapping
    public String guardarProducto(@ModelAttribute Producto producto, Model model) {
        try {
            if (producto.getId_prod() != null && !producto.getId_prod().trim().isEmpty()) {
                productoService.updateProducto(producto.getId_prod(), producto);
                model.addAttribute("alerta", Alert.sweetAlertSuccess("Producto actualizado correctamente"));
            } else {
                productoService.createProducto(producto);
                model.addAttribute("alerta", Alert.sweetAlertSuccess("Producto registrado correctamente"));
            }
        } catch (Exception e) {
            model.addAttribute("alerta", Alert.sweetAlertError("Error al guardar: " + e.getMessage()));
        }

        cargarCombos(model);
        model.addAttribute("producto", new Producto()); // Limpiar formulario
        return "ViewCrud";
    }
}