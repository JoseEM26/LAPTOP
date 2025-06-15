package MYSQLConnection.ConecctionMYSQL.Repositorio;

import MYSQLConnection.ConecctionMYSQL.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<UserModel , Long> {
}
