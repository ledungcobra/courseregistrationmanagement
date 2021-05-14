package com.ledungcobra.entites.embedable;

import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class StudentCourseId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE_STUDENT"))
    private Student student;

    @Embedded
    private CourseId courseId;

}
