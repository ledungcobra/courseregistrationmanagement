package com.ledungcobra.entites;


import com.ledungcobra.entites.embedable.StudentCourseSemesterId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STUDENT_COURSE_SEMESTER")
@Getter
@Setter
public class StudentCourseSemester extends BaseEntity {

    @EmbeddedId
    private StudentCourseSemesterId studentCourseSemesterId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SESSION_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE_SEMESTER_To_COURSE_REGISTRATION_SESSION"))
    private CourseRegistrationSession session;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentCourseSemester that = (StudentCourseSemester) o;
        return Objects.equals(studentCourseSemesterId, that.studentCourseSemesterId) && Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentCourseSemesterId, session);
    }
}
