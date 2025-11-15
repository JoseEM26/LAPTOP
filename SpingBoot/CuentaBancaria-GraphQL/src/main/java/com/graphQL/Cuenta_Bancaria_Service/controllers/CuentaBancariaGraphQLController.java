package com.graphQL.Cuenta_Bancaria_Service.controllers;

import com.graphQL.Cuenta_Bancaria_Service.Model.CuentaBancaria;
import com.graphQL.Cuenta_Bancaria_Service.Repository.CuentaBancariaRepository;
import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaRequestDto;
import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaResponseDto;
import com.graphQL.Cuenta_Bancaria_Service.services.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CuentaBancariaGraphQLController {

    @Autowired
    public CuentaBancariaRepository cuentaBancariaRepository;

    @Autowired
    public CuentaBancariaService cuentaBancariaService;
    @QueryMapping
    public List<CuentaBancaria> listarCuentas(){
        return cuentaBancariaRepository.findAll();
    }

    @QueryMapping
    public CuentaBancaria cuentaBancariaPorId(@Argument String id){
        System.out.println("ID recibido: [" + id + "]");
        List<CuentaBancaria> cuentas = cuentaBancariaRepository.findAll();
        for(CuentaBancaria cuenta:cuentas){
            if(cuenta.getId().trim().equals(id.trim())){
                System.out.println("Coinciendia exacta encontrada");
                return cuenta;
            }
        }
        throw new RuntimeException("Cuenta [" + id + "] no encontrada");
    }

    @MutationMapping
    public CuentaBancariaResponseDto agregarCuenta(@Argument CuentaBancariaRequestDto cuentaBancaria){
        return cuentaBancariaService.addCuenta(cuentaBancaria);
    }

    @MutationMapping
    public CuentaBancariaResponseDto actualizarCuenta(@Argument String id, @Argument CuentaBancariaRequestDto cuentaBancaria){
        return cuentaBancariaService.updateCuenta(id,cuentaBancaria);
    }

    @MutationMapping
    public void eliminarCuenta(@Argument String id){
        cuentaBancariaRepository.deleteById(id);
    }


}
