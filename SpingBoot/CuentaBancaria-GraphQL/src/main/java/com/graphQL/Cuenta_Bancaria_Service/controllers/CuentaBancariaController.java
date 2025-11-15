package com.graphQL.Cuenta_Bancaria_Service.controllers;

import com.graphQL.Cuenta_Bancaria_Service.Model.CuentaBancaria;
import com.graphQL.Cuenta_Bancaria_Service.Repository.CuentaBancariaRepository;
import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaRequestDto;
import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaResponseDto;
import com.graphQL.Cuenta_Bancaria_Service.services.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class CuentaBancariaController {

    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;
    @Autowired
    private CuentaBancariaService cuentaBancariaService;

    @GetMapping("/cuentas")
    public List<CuentaBancaria> listaCuentasBancarias(){
        return cuentaBancariaRepository.findAll();
    }

    @GetMapping("/cuentas/{id}")
    public CuentaBancaria obtenerCuentaBancaria(@PathVariable String id){
        return cuentaBancariaRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Cuenta no se encontro"+id)));
    }

    @PostMapping("/cuentas")
    public CuentaBancariaResponseDto guardarCuenta(@RequestBody CuentaBancariaRequestDto cuentaBancariaRequestDto){
        return cuentaBancariaService.addCuenta(cuentaBancariaRequestDto);
    }

    @PutMapping("/cuentas/{id}")
    public CuentaBancaria actualizarCuentaBancaria(@PathVariable String id, @RequestBody CuentaBancaria cuentaBancaria){

        CuentaBancaria cuentaBancariaDBB=cuentaBancariaRepository.findById(id).orElseThrow();
        cuentaBancariaDBB.setBalance(cuentaBancaria.getBalance());
        cuentaBancariaDBB.setDivisa(cuentaBancaria.getDivisa());
        cuentaBancariaDBB.setFechaCreacion(new Date());
        cuentaBancariaDBB.setTipoCuenta(cuentaBancaria.getTipoCuenta());
        return cuentaBancariaRepository.save(cuentaBancariaDBB);
    }

    @DeleteMapping("/cuentas/{id}")
    public void eliminarCuenta(@PathVariable String id){
         cuentaBancariaRepository.deleteById(id);
    }
}











