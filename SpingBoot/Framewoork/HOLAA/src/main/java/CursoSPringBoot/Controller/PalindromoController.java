package CursoSPringBoot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromoController {

    @GetMapping("/palindromo/{palabra}")
    public String Palindromo(@PathVariable String palabra){

        if(palabra.equalsIgnoreCase(new StringBuilder(palabra).reverse().toString())){
            return "Si es PALINDROMO";

        }else{
            return  "NO es PALINDROMO";
        }


    }
}
