package com.Security21.SpringSecurity.JWT.Repository;

import com.Security21.SpringSecurity.JWT.Model.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity,Long> {
}
