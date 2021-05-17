package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COURSE_REGISTRATION_SESSION")
@Getter
@Setter
public class CourseRegistrationSession extends BaseEntity {

    @Id
    @Column(name = "CSR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "SEMESTER_NAME"),
            @JoinColumn(name = "YEAR")
    }, foreignKey = @ForeignKey(name = "FK_COURSE_REGISTRATION_SESSION_SEMESTER"))
    private Semester semester;


}
