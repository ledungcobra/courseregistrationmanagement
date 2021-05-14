package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import static com.ledungcobra.utils.Constants.SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME;

@Entity
@Table(name = "Semester")
@Getter
@Setter
public class Semester extends BaseEntity{

    @Id
    @Column(name = "SEMESTER_ID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SEMESTER_NAME", columnDefinition = "VARCHAR(255) CHARSET utf8 " + SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME)
    private String semesterName;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "YEAR")
    private Integer year;

}

