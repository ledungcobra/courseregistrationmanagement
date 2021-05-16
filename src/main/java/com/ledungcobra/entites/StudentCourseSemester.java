package com.ledungcobra.entites;


import com.ledungcobra.entites.embedable.StudentCourseSemesterId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_COURSE_SEMESTER")
@Getter
@Setter
public class StudentCourseSemester extends BaseEntity {

    @EmbeddedId
    private StudentCourseSemesterId studentCourseSemesterId;

    @ManyToOne
    @JoinColumn(name = "SESSION_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE_SEMESTER_To_COURSE_REGISTRATION_SESSION"))
    private CourseRegistrationSession session;


}
