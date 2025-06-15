package com.SprinSecurity.Seguridad2.Repository;

import com.SprinSecurity.Seguridad2.Model.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity , Long> {
}
