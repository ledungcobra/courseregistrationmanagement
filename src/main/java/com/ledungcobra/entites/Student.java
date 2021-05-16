package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Student")
@Getter
@Setter
public class Student extends User {

    @Id
    @Column(name = "STUDENT_ID")
    private String id;

    @Column(name = "GENDER")
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASS_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_CLASS"))
    private Class studiedClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", foreignKey = @ForeignKey(name = "FK_STUDENT_TEACHING_MANAGER"))
    private TeachingManager createdBy;

}
