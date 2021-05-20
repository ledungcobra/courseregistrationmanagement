package com.ledungcobra.entites;

import com.ledungcobra.entites.embedable.StudentAccountId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT_ACCOUNT")
@Getter
@Setter
public class StudentAccount extends User {

    @EmbeddedId
    private StudentAccountId studentAccountId;

    @Column(name = "STUDENT_CARD_ID", nullable = false,unique = true)
    private String studentCardId;

    @JoinColumn(name = "CLASS_ID")
    @ManyToOne
    private Class studiedClass;

    @Override
    public String getUserName() {
        return studentCardId;
    }
}
