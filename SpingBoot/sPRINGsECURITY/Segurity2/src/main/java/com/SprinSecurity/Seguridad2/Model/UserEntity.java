package com.SprinSecurity.Seguridad2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 90)
    private String email;

    @NotBlank
    @Size(max = 90)
    private String username;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER ,targetEntity = RoleEntity.class ,cascade = CascadeType.PERSIST )
    @JoinTable(name = "user_roles" , joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity > roles;

    public UserEntity() {
    }

    public UserEntity(Long id, String email, String username, String password, Set<RoleEntity> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
