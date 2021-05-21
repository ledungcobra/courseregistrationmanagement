package com.ledungcobra.entites.embedable;

import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.Semester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CourseSemesterId implements Serializable {

    @ManyToOne
    @JoinColumn(name="COURSE_ID")
    private Course course;

    @ManyToOne
    @JoinColumns(value = {@JoinColumn(name = "SEMESTER_NAME"), @JoinColumn(name = "YEAR")})
    private Semester semester;


}
