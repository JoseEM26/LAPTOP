package com.graphQL.Cuenta_Bancaria_Service.dto;

import com.graphQL.Cuenta_Bancaria_Service.Model.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancariaRequestDto {
    private double balance;
    private String divisa;
    private TipoCuenta tipoCUenta;
}
