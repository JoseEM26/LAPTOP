package com.graphQL.Cuenta_Bancaria_Service.dto;

import com.graphQL.Cuenta_Bancaria_Service.Model.TipoCuenta;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancariaResponseDto {
    private String id;
    private Date fechaCreacion;
    private double balance;
    private String divisa;
    private TipoCuenta tipoCUenta;
}
