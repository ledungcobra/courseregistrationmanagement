package com.ledungcobra.entites;

import com.ledungcobra.entites.embedable.StudentAccountId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "STUDENT_ACCOUNT")
@Getter
@Setter
public class StudentAccount extends User {

    @EmbeddedId
    private StudentAccountId studentAccountId;

    @Column(name = "STUDENT_CARD_ID", nullable = false, unique = true)
    private String studentCardId;

    public StudentAccount(StudentAccountId studentAccountId, String studentCardId, String fullName) {
        super(fullName, studentCardId);
        this.studentAccountId = studentAccountId;
        this.studentCardId = studentCardId;
        this.password = studentCardId;
    }

    @JoinColumn(name = "CLASS_ID")
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Class studiedClass;


    public StudentAccount() {
    }

    @Override
    public void create() {
        super.create();
        this.password = studentCardId;
    }

    @Override
    public String getUserName() {
        return studentCardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentAccount that = (StudentAccount) o;
        return Objects.equals(studentAccountId, that.studentAccountId) && Objects.equals(studentCardId, that.studentCardId) && Objects.equals(studiedClass, that.studiedClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentAccountId, studentCardId, studiedClass);
    }
}
