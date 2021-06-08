package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EDUCATION_TYPE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class EducationType extends BaseEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EDUCATION_TYPE_ID")
    @EqualsAndHashCode.Include
    private Long id;


    public EducationType(String name)
    {
        this.name = name;
    }

    @Column(name = "NAME")
    private String name;

    @Override
    public String toString()
    {
        return name;
    }
}
