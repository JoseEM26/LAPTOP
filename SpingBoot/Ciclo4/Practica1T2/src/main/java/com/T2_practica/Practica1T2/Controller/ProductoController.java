package com.T2_practica.Practica1T2.Controller;

import com.T2_practica.Practica1T2.Model.Producto;
import com.T2_practica.Practica1T2.Repository.CategoriaRepository;
import com.T2_practica.Practica1T2.Repository.InventarioRepository;
import com.T2_practica.Practica1T2.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    CategoriaRepository _caCategoriaRepository;

    @Autowired
    InventarioRepository _inveInventarioRepository;

    @Autowired
    ProductoRepository _prodProductoRepository;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("lista",_prodProductoRepository.findAll());

        return "producto/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("producto",new Producto());
        model.addAttribute("categorias" ,_caCategoriaRepository.findAll());
        return  "producto/create";
    }

}
