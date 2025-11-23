package com.ciberfarma.dawi_tema03.controller;

import com.ciberfarma.dawi_tema03.model.Producto;
import com.ciberfarma.dawi_tema03.service.CategoriaService;
import com.ciberfarma.dawi_tema03.service.ProductoService;
import com.ciberfarma.dawi_tema03.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;
    private final ProveedorService proveedorService;

    private void cargarDatosComunes(Model model) {
        model.addAttribute("cboCategoria", categoriaService.cboCategoria());
        model.addAttribute("cboProveedor", proveedorService.cboProveedor());
        model.addAttribute("listaProductos", productoService.listarProducto());
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("producto", new Producto());
        cargarDatosComunes(model);
        return "crudproductos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") String id, Model model) {
        Producto p = productoService.findProducto(id);
        model.addAttribute("producto", p != null ? p : new Producto());
        cargarDatosComunes(model);
        return "crudproductos";
    }

    @PostMapping("/editar/create")
    public String guardar(@ModelAttribute("producto") Producto producto, Model model) {
        try {
            if (producto.getId_prod() == null || producto.getId_prod().trim().isEmpty()) {
                productoService.agregarProducto(producto);
                model.addAttribute("mensaje", "Producto registrado correctamente");
                model.addAttribute("tipoMensaje", "success");
            } else {
                productoService.agregarProducto(producto);
                model.addAttribute("mensaje", "Producto actualizado correctamente");
                model.addAttribute("tipoMensaje", "success");
            }
        } catch (Exception e) {
            model.addAttribute("mensaje", "Error al guardar: " + e.getMessage());
            model.addAttribute("tipoMensaje", "error");
        }

        cargarDatosComunes(model);
        model.addAttribute("producto", producto);
        return "crudproductos";
    }
}