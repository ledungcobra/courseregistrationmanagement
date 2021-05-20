package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Student_Info")
@Getter
@Setter
public class StudentInfo {

    @Id
    @Column(name = "STUDENT_INFO_ID")
    private Long id;

    @Column(name = "GENDER", columnDefinition = "varchar(255) CHECK(GENDER IN('Boy','Girl'))")
    private String gender;

    @Column(name = "BIRTHDAY")
    private Date date;

    @Column(name = "IDENTITY_CARD_NUMBER", unique = true,nullable = false)
    private String identityCardNumber;


}
