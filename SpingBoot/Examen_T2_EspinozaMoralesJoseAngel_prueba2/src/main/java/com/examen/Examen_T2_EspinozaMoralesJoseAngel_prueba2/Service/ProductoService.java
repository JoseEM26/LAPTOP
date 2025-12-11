package com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Service;

import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model.Producto;
import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository _ProductoRepository;

    public List<Producto> listaProducto(){
        return _ProductoRepository.findAll();
    }
    public Optional<Producto> filtrarProducto(String id) {
        return _ProductoRepository.findById(id);
    }

    public Producto createProducto(Producto producto){
        return _ProductoRepository.save(producto);
    }

    public Producto updateProducto(String id, Producto producto) {
        return _ProductoRepository.findById(id).map(productoExistente -> {
            productoExistente.setDes_prod(producto.getDes_prod());
            productoExistente.setStk_prod(producto.getStk_prod());
            productoExistente.setPre_prod(producto.getPre_prod());
            productoExistente.setEst_prod(producto.getEst_prod());
            productoExistente.setCategoria(producto.getCategoria());
            productoExistente.setProveedor(producto.getProveedor());
            return _ProductoRepository.save(productoExistente);
        }).orElseThrow(() -> new RuntimeException(" no encontrado con id: " + id));
    }
}
