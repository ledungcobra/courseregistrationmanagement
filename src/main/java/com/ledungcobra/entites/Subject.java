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
@Table(name = "Subject")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Subject extends BaseEntity
{

    @Id
    @Column(name = "SUBJECT_ID")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "SUBJECT_NAME", unique = true)
    private String name;

    @Column(name = "SUBJECT_CREDIT", nullable = false)
    private Integer credit;

    public Subject(String id, String name, Integer credit)
    {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }


    @Override
    public String toString()
    {
        return this.name + " - " + this.credit + (this.credit.equals(1) ? " credit" : " credits");
    }
}
