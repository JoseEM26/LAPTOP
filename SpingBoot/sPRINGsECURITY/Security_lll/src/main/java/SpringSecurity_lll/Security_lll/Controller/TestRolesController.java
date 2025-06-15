package SpringSecurity_lll.Security_lll.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {

    @GetMapping("/accessAdmin")
    public String accessAdmin(){
         return "Hola , haz Accedido como Administrado";
    }
    @GetMapping("/accessUser")
    public String accessUser(){
        return "Hola , haz Accedido como User";
    }
    @GetMapping("/accessInvited")
    public String accessInvited(){
        return "Hola , haz Accedido como Invited";
    }


}
