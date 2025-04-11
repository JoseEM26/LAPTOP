package com.Security21.SpringSecurity.JWT.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @NotEmpty
    @ManyToMany(targetEntity = RoleEntity.class , cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles" , joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String email, String password, Set<RoleEntity> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
