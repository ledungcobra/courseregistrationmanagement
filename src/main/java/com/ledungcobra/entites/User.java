package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class User extends BaseEntity {

    @Column(name = "FULL_NAME",columnDefinition = "VARCHAR(255) CHARSET utf8")
    protected String fullName;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

    public abstract String getUserName();

}
