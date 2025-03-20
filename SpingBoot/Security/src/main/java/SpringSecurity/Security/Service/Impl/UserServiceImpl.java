package SpringSecurity.Security.Service.Impl;

import SpringSecurity.Security.Model.User;
import SpringSecurity.Security.Service.UserService;
import SpringSecurity.Security.constantes.FacturaConstantes;
import SpringSecurity.Security.dao.UserDAO;
import SpringSecurity.Security.util.FacturaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public ResponseEntity<String> signUp(@RequestBody User user) {
        try {
            if (isValidUser(user)) {
                if (Objects.isNull(userDAO.findByEmail(user.getEmail()))) {
                    user.setRole("user"); // Valores por defecto
                    user.setStatus("false");
                    userDAO.save(user);
                    return FacturaUtils.GetResponseEntity("Usuario Registrado exitosamente", HttpStatus.CREATED);
                } else {
                    return FacturaUtils.GetResponseEntity("El usuario ya existe", HttpStatus.BAD_REQUEST);
                }
            } else {
                return FacturaUtils.GetResponseEntity("Datos incompletos", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FacturaUtils.GetResponseEntity(FacturaConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Boolean isValidUser(User user) {
        return user.getNombre() != null &&
                user.getEmail() != null &&
                user.getPassword() != null &&
                user.getNumeroDeContacto() != null;
    }
}
