package com.Clase3.Excepciones.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/division")
public class Operaciones {

    @GetMapping()
    public String Divide(@RequestParam(name = "numerador") String numeroString,
            @RequestParam(name = "denominador") String denomString) {

        try {
            int numerador = Integer.parseInt(numeroString);
            int denominador = Integer.parseInt(denomString);
            int resultado = numerador / denominador;
            return "Resultado es :" + resultado;
        } catch (ArithmeticException e) {
            throw e;
        } catch (NumberFormatException e) {
            throw e;
        }

    }

}

@RestController
class Null_p_e {
    @GetMapping("valorNullo")
    public String Nullo() {


        String valor= null;
        valor.length();

        return "Valor Nullo en la variable";
    }
}