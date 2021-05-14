package com.ledungcobra.entites.embedable;

import com.ledungcobra.entites.Semester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CourseId implements Serializable {

    @Column(name = "COURSE_ID")
    private String courseId;

    @ManyToOne
    @JoinColumn(name = "SEMESTER_ID")
    private Semester semester;

}
