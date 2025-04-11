package CursoSPringBoot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/saludo/{name}")
    public String greet(@PathVariable String name){
        return "Hola"+name;
    }
}
