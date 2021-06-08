package com.ledungcobra.entites.embedable;

import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.StudentAccount;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class StudentCourseId implements Serializable
{

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "STUDENT_ID")
    @EqualsAndHashCode.Include
    private StudentAccount studentAccount;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "COURSE_ID")
    @EqualsAndHashCode.Include
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEMESTER_ID")
    @EqualsAndHashCode.Include
    private Semester semester;

}
