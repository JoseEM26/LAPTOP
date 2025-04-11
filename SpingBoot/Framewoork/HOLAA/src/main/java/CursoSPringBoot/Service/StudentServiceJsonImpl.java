package CursoSPringBoot.Service;

import CursoSPringBoot.Model.Students;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//@Primary
@Service
@ConditionalOnProperty(name="service.produce" , havingValue = "JSON")
public class StudentServiceJsonImpl  implements  StudentService{
@Aut
    @Override
    public <?> GetStudent() {
        List<Students> Students;

        try {
            Students = new ObjectMapper().
                    readValue(this.getClass().
                    getResourceAsStream("Student.json"), new TypeReference<List<Students>>() {
            });

            return ResponseEntity.ok(Students);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
