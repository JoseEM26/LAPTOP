package com.ciberfarma.dawi_tema03.service;

import com.ciberfarma.dawi_tema03.model.Producto;
import com.ciberfarma.dawi_tema03.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository _ProductoRepository;

    public List<Producto> listarProducto(){
        List<Producto> lista=_ProductoRepository.findAll();
        return lista;
    }


    public Producto findProducto(String id){
        Producto lista=_ProductoRepository.findById(id).orElse(null);
        return lista;
    }

    public Producto agregarProducto(Producto p){
        return _ProductoRepository.save(p);
    }

    public Producto updateProducto(String id_prod,Producto producto){
        return _ProductoRepository.findById(id_prod).map(x->{
            x.setDes_prod(producto.getDes_prod());
            x.setStk_prod(producto.getStk_prod());
            x.setPre_prod(producto.getPre_prod());
            x.setIdcategoria(producto.getIdcategoria());
            x.setEst_prod(producto.getEst_prod());
            x.setIdproveedor(producto.getIdproveedor());
            return _ProductoRepository.save(producto);
        }).orElseThrow(null);
    }
}
