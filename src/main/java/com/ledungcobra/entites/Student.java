package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Student")
@Getter
@Setter
public class Student extends User {

    @Id
    @Column(name = "STUDENT_ID")
    private String id;

    @Column(name = "GENDER", columnDefinition = "varchar(255) CHECK(GENDER IN('Boy','Girl'))")
    private String gender;

    @Column(name = "BIRTHDAY")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASS_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_CLASS"))
    private Class studiedClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", foreignKey = @ForeignKey(name = "FK_STUDENT_TEACHING_MANAGER"))
    private TeachingManager createdBy;


}
