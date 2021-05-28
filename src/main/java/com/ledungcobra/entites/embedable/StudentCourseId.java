package com.ledungcobra.entites.embedable;

import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.StudentAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class StudentCourseId implements Serializable {

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "STUDENT_ID")
    private StudentAccount studentAccount;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEMESTER_ID")
    private Semester semester;

    public StudentCourseId(StudentAccount student, Course course, Semester semester) {
        this.studentAccount = student;
        this.course = course;
        this.semester = semester;
    }
}