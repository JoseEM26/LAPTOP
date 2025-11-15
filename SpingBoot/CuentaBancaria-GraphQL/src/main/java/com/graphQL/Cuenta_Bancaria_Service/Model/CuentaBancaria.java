package com.graphQL.Cuenta_Bancaria_Service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancaria {
    @Id
    private String id;
    private Date fechaCreacion;
    private Double balance;
    private String divisa;

    @Enumerated(EnumType.STRING)
    private TipoCuenta tipoCuenta;
}
