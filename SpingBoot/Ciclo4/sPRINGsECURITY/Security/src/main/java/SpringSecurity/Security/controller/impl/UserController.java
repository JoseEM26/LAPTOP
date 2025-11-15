package SpringSecurity.Security.controller.impl;

import SpringSecurity.Security.Model.User;
import SpringSecurity.Security.Service.Impl.UserServiceImpl;
import SpringSecurity.Security.constantes.FacturaConstantes;
import SpringSecurity.Security.util.FacturaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping("/")
    public ResponseEntity<String> RegistrarUsuario(@RequestBody(required = true) User user){
          try {
              return service.signUp(user);
          }catch (Exception e){
              e.printStackTrace();
          }
          return FacturaUtils.GetResponseEntity(FacturaConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
