package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class User extends BaseEntity {

    @Column(name = "USERNAME", nullable = false, unique = true)
    protected String userName;

    @Column(name = "PASSWORD", nullable = false)
    protected String password;

}
