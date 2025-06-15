package SpringSecurity.Security.Security;

import SpringSecurity.Security.Model.User;
import SpringSecurity.Security.dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    private User userDetails;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        userDetails = userDAO.findByEmail(username);

        if(!Objects.isNull(userDetails)){
            return new org.springframework.security.core.userdetails.User(userDetails.getEmail(),userDetails.getPassword(),new ArrayList<>());

        }else {
            throw new UsernameNotFoundException("Usuario no Encontrado");
        }
    }

    public User getUserDetails(){
        return userDetails;
    }

}
