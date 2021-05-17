package com.ledungcobra.entites;

import com.ledungcobra.entites.embedable.SemesterId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static com.ledungcobra.utils.Constants.SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME;

@Entity
@Table(name = "Semester")
@Getter
@Setter
public class Semester extends BaseEntity {

    @EmbeddedId
    private SemesterId id;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToMany(mappedBy = "semesters", fetch = FetchType.LAZY)
    private List<Course> courses;

}

