package com.graphQL.Cuenta_Bancaria_Service.mapper;

import com.graphQL.Cuenta_Bancaria_Service.Model.CuentaBancaria;
import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CuentaBancariaMapper {
    public CuentaBancariaResponseDto fromCuentabancaria(CuentaBancaria cuentaBancaria){
        CuentaBancariaResponseDto cuentaBancariaResponseDto=new CuentaBancariaResponseDto();
        BeanUtils.copyProperties(cuentaBancaria,cuentaBancariaResponseDto);
        return  cuentaBancariaResponseDto;

    }
}
