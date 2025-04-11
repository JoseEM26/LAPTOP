package com.Security21.SpringSecurity.JWT.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public RoleEntity(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }
    public RoleEntity(ERole name) {
        this.name = name;
    }


    public RoleEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
