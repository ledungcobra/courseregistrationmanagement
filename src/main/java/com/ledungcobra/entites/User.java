package com.ledungcobra.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class User extends BaseEntity
{

    @Column(name = "PASSWORD", nullable = false)
    protected String password;

    public User(String password)
    {
        this.password = password;
    }

    public abstract String getUserId();

    public abstract String getFullName();


}
