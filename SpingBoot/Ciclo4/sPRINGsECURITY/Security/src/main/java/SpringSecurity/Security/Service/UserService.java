package SpringSecurity.Security.Service;

import SpringSecurity.Security.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<String> signUp(User user);
}
