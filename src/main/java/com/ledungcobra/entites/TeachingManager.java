package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHING_MANAGER")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class TeachingManager extends User
{

    @Id
    @Column(name = "TEACHING_MANAGER_ID")
    @EqualsAndHashCode.Include
    private String id;


    @Column(name = "FULL_NAME", columnDefinition = "VARCHAR(255) CHARSET utf8")
    protected String fullName;

    public TeachingManager(String id, String fullName, String password)
    {
        super(password);
        this.id = id;
        this.fullName = fullName;
    }

    @Override
    public String getUserId()
    {
        return this.id;
    }

}
