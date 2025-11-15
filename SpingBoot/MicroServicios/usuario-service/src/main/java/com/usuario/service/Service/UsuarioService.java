package com.usuario.service.Service;

import com.usuario.service.Entidades.Usuario;
import com.usuario.service.Repository.UsuarioRepository;
import com.usuario.service.feignClients.CarroFeignClient;
import com.usuario.service.feignClients.MotoFeignClient;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository _UsuarioRepository;
    @Autowired
    private RestTemplate _RestTemplate;
    @Autowired
    private CarroFeignClient _CarroFeignClient;
    @Autowired
    private MotoFeignClient _MotoFeignClient;

    public List<Carro> getCarros(Integer usuarioId){
        List<Carro> carros=_RestTemplate.getForObject("http://localhost:8082/carro/usuario/"+usuarioId,List.class);
        return carros;
    }

    public List<Moto> getMotos(Integer usuarioId){
        List<Moto> motos=_RestTemplate.getForObject("http://localhost:8083/moto/usuario/"+usuarioId,List.class);
        return motos;
    }

    public List<Usuario> listarUsuario(){
        return _UsuarioRepository.findAll();
    }

    public Usuario getUsuarioByID(Integer id){
        return _UsuarioRepository.findById(id).orElseThrow(null);
    }

    public Usuario createUsuario(Usuario newUsuario){
        Usuario usuario=_UsuarioRepository.save(newUsuario);
        return usuario;
    }

    public Carro saveCarro(Integer usuarioId ,Carro carro){
        carro.setUsuarioId(usuarioId);
        Carro nuevoCarro=_CarroFeignClient.save(carro);
        return nuevoCarro;

    }
    public Moto saveMoto(Integer usuarioId ,Moto moto){
        moto.setUsuarioId(usuarioId);
        Moto nuevoMoto=_MotoFeignClient.saveMoto(moto);
        return nuevoMoto;
    }

    public Map<String , Object> getUsuarioAndVahiculo(Integer usuarioId){
        Map<String,Object> resultado=new HashMap<>();
        Usuario usuario=_UsuarioRepository.findById(usuarioId).orElseThrow(null);
        if(usuario==null){
            resultado.put("Mensaje","El usuario no existe");
        }
        resultado.put("Usuario",usuario);

        List<Carro> carros=_CarroFeignClient.getCarros(usuarioId);
        if(carros.isEmpty()){
            resultado.put("Mensaje","El carro no existe o no hay nada");
        }
        resultado.put("Carros",carros);


        List<Moto> motos =_MotoFeignClient.getMotos(usuarioId);
        if(motos.isEmpty()){
            resultado.put("Mensaje","El motos no existe o no hay nada");
        }
        resultado.put("Motos", motos);

        return resultado;
    }





}
