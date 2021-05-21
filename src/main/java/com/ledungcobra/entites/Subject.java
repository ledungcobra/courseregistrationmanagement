package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Subject")
@Getter
@Setter
public class Subject extends BaseEntity{

    @Id
    @Column(name = "SUBJECT_ID")
    private String id;

    @Column(name = "SUBJECT_NAME",unique = true)
    private String name;

    @Column(name = "SUBJECT_CREDIT", nullable = false)
    private Integer credit;

    public Subject(String id, String name, Integer credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public Subject() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) && Objects.equals(name, subject.name) && Objects.equals(credit, subject.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, credit);
    }
}
