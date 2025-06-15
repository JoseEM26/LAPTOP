package SpringSecurity_lll.Security_lll.Repository;

import SpringSecurity_lll.Security_lll.Model.ERole;
import SpringSecurity_lll.Security_lll.Model.RolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<RolEntity , Long> {
    Optional<RolEntity> findByName(ERole name);
}
