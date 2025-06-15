package CursoSPringBoot.Controller;

import CursoSPringBoot.Model.Customer;
import CursoSPringBoot.Model.Students;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentsAPPController {

    public List<Students> lista= new ArrayList<Students>(Arrays.asList(
            new Students("Jose","joseangel@gmai.com","matematicas",100,20),
            new Students("Naydelin","Ivana@gmai.com","COunidacaion",200,8),
            new Students("Ivana","Naydelin@gmai.com","Informatica",120,22)
    ));

    @GetMapping
    public List<Students> GetLista(){
        return  lista;
    }

    @GetMapping("/{id}")
    public Students GetSutdent(@PathVariable int id){
        Students newStudent= lista.stream().filter(x->x.getId()== id).findFirst().orElse(null);
        return  newStudent;
    }

    @PostMapping
    public Students PostStudent(@RequestBody Students student){
        lista.add(student);
        return student;
    }

    @PutMapping
    public Students PutStudent(@RequestBody Students student){

        for(Students s :lista){
            if(s.getId()==student.getId()){
                s.setAge(student.getAge());
                s.setCourse(student.getCourse());
                s.setEmail(student.getEmail());
                s.setNombre(student.getNombre());
            }
        }

        return student;
    }

    @DeleteMapping("/{id}")
    public Students DeleteStudent(@PathVariable int id){
        for(Students s : lista){
            if(s.getId()==id){
                lista.remove(s);
                return  s;
            }
        }
        return  null;
    }










}
