package com.SprinSecurity.Seguridad2.Repository;

import com.SprinSecurity.Seguridad2.Model.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity> findByName(String username);
}
