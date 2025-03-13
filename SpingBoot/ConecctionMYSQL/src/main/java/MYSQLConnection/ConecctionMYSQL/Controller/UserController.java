package MYSQLConnection.ConecctionMYSQL.Controller;

import MYSQLConnection.ConecctionMYSQL.Model.UserModel;
import MYSQLConnection.ConecctionMYSQL.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel SaveUser(@RequestBody UserModel user){
        return this.userService.SaveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> findByID(@PathVariable Long id){
        return this.userService.getByID(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel PutUser(@RequestBody UserModel user,@PathVariable Long id){
        return this.userService.UpdateUser(user,id);
    }

    @DeleteMapping(path = "/{id}")
    public String DeleteUser(@PathVariable Long id){
        Boolean ok=  this.userService.DeleteUser(id);
        if(ok){
            return "user with id :"+id +" deleted";
        }else {
            return "Hubo un error xd";
        }
    }


}
