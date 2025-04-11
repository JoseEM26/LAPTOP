package SpringSecurity_lll.Security_lll.Service;

import SpringSecurity_lll.Security_lll.Model.UserEntity;
import SpringSecurity_lll.Security_lll.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=  userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario "+username + " No existe bebe"));

        Collection<? extends GrantedAuthority> authorities=userEntity.getRoles().stream()
                .map(rolEntity -> new SimpleGrantedAuthority("ROLE_".concat(rolEntity.getName().name())))
                .collect(Collectors.toSet());

        return new User(userEntity.getUsername()
                ,userEntity.getPassword()
                , true
                , true
                , true
                ,true
                ,authorities );
    }
}
