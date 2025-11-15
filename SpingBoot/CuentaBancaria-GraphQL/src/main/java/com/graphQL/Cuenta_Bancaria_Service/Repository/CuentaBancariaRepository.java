package com.graphQL.Cuenta_Bancaria_Service.Repository;


import com.graphQL.Cuenta_Bancaria_Service.Model.CuentaBancaria;
import com.graphQL.Cuenta_Bancaria_Service.Model.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria,String> {

    @RestResource(path = "/byType")
    List<CuentaBancaria> findByTipoCuenta(@Param("t") TipoCuenta tipoCuenta);


    //http://localhost:8080/cuentaBancarias/search/byType?t=CUENTA_CORRIENTE&projection=p1
    //http://localhost:8080/swagger-ui/index.html#

}