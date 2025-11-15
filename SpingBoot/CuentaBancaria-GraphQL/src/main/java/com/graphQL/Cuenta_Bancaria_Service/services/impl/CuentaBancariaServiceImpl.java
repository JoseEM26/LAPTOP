package com.graphQL.Cuenta_Bancaria_Service.services.impl;

import com.graphQL.Cuenta_Bancaria_Service.Model.CuentaBancaria;
import com.graphQL.Cuenta_Bancaria_Service.Repository.CuentaBancariaRepository;
import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaRequestDto;
import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaResponseDto;
import com.graphQL.Cuenta_Bancaria_Service.mapper.CuentaBancariaMapper;
import com.graphQL.Cuenta_Bancaria_Service.services.CuentaBancariaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class CuentaBancariaServiceImpl implements CuentaBancariaService {
    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;
    @Autowired
    private  CuentaBancariaMapper cuentaBancariaMapper;

    @Override
    public CuentaBancariaResponseDto addCuenta(CuentaBancariaRequestDto cuentaBancariaRequestDto) {
        CuentaBancaria cuentaBancaria= CuentaBancaria.builder()
                .id(UUID.randomUUID().toString())
                .fechaCreacion(new Date())
                .balance(cuentaBancariaRequestDto.getBalance())
                .tipoCuenta(cuentaBancariaRequestDto.getTipoCUenta())
                .divisa(cuentaBancariaRequestDto.getDivisa())
                .build();
        CuentaBancaria cuentaBancariaBBBDD= cuentaBancariaRepository.save(cuentaBancaria);
        CuentaBancariaResponseDto cuentaBancariaResponseDto=cuentaBancariaMapper.fromCuentabancaria(cuentaBancariaBBBDD);
        return  cuentaBancariaResponseDto;
    }
    @Override
    public CuentaBancariaResponseDto updateCuenta(String id, CuentaBancariaRequestDto cuentaBancariaRequestDto) {
        CuentaBancaria cuentaBancaria = CuentaBancaria.builder()
                .id(id)
                .fechaCreacion(new Date())
                .balance(cuentaBancariaRequestDto.getBalance())
                .tipoCuenta(cuentaBancariaRequestDto.getTipoCUenta())
                .divisa(cuentaBancariaRequestDto.getDivisa())
                .build();

        CuentaBancaria cuentaBancariaBBDD = cuentaBancariaRepository.save(cuentaBancaria);
        CuentaBancariaResponseDto cuentaBancariaResponseDto = cuentaBancariaMapper.fromCuentabancaria(cuentaBancariaBBDD);
        return cuentaBancariaResponseDto;
    }

}
