package com.graphQL.Cuenta_Bancaria_Service.services;

import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaRequestDto;
import com.graphQL.Cuenta_Bancaria_Service.dto.CuentaBancariaResponseDto;

public interface CuentaBancariaService {

    CuentaBancariaResponseDto addCuenta(CuentaBancariaRequestDto cuentaBancariaRequestDto);
    CuentaBancariaResponseDto updateCuenta(String id,CuentaBancariaRequestDto cuentaBancariaRequestDto);

}
