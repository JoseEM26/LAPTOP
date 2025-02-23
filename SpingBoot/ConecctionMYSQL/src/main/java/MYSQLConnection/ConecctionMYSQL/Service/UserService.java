package MYSQLConnection.ConecctionMYSQL.Service;

import MYSQLConnection.ConecctionMYSQL.Model.UserModel;
import MYSQLConnection.ConecctionMYSQL.Repositorio.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepositorio userRepositorio;


    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepositorio.findAll();
    }

    public UserModel SaveUser(UserModel user){
        return userRepositorio.save(user);
    }

    public Optional<UserModel> getByID(Long id){
        return userRepositorio.findById(id);
    }


    public UserModel UpdateUser(UserModel user, Long id){
        Optional<UserModel> userOptional = userRepositorio.findById(id);

        if(userOptional.isPresent()){
            UserModel existingUser = userOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            return userRepositorio.save(existingUser);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }


    public Boolean DeleteUser(Long id){
        if(userRepositorio.existsById(id)){
            userRepositorio.deleteById(id);
            return true;
        }
        return false;
    }




}
