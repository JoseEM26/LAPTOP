package com.FullStackClase1.Curso.Controller;

import com.FullStackClase1.Curso.Model.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario100")
    public Usuario GetUsuario(){
        Usuario u= new Usuario(100L,"Jose","Espinoza","email","555555555","joseangel1");
       return  u;
    }

    @RequestMapping(value = "usuario/lista")
    public List<Usuario> ListaUsuario(){
        List<Usuario> usuarios=new ArrayList<>();
        usuarios.add(  new Usuario(111L,"Naydelin","Espinoza","email","555555555","joseangel1"));
        usuarios.add(  new Usuario(112L,"Jose","Morales","gmail","1111111","espinozaesinoza"));
        usuarios.add(  new Usuario(113L,"Ivana","Ayala","outloook","99999999","papito"));
        return  usuarios;
    }

}
