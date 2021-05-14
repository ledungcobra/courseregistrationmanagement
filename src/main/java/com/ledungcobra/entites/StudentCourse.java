package com.ledungcobra.entites;


import com.ledungcobra.entites.embedable.StudentCourseId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_COURSE")
@Getter
@Setter
public class StudentCourse extends BaseEntity {

    @EmbeddedId
    private StudentCourseId studentCourseId;

    @ManyToOne
    @JoinColumn(name = "SESSION_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE__COURSE_REGISTRATION_SESSION"))
    private CourseRegistrationSession session;


}
