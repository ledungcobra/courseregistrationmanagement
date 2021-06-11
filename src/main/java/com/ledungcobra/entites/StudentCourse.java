package com.ledungcobra.entites;


import com.ledungcobra.entites.embedable.StudentCourseId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_COURSE", uniqueConstraints = @UniqueConstraint(name = "UK_STUDENT_COURSE", columnNames = {
        "COURSE_ID", "STUDENT_ID",
}))
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class StudentCourse extends BaseEntity
{

    @EmbeddedId
    @EqualsAndHashCode.Include
    private StudentCourseId studentCourseId;

    @JoinColumn(name = "SESSION_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE_COURSE_REGISTRATION_SESSION"))
    @ManyToOne(fetch = FetchType.LAZY)
    private CourseRegistrationSession courseRegistrationSession;

    public StudentCourse(CourseRegistrationSession courseRegistrationSession, Course course, StudentAccount studentAccount, Semester semester)
    {
        this.courseRegistrationSession = courseRegistrationSession;
        this.studentCourseId = new StudentCourseId();
        this.studentCourseId.setCourse(course);
        this.studentCourseId.setStudentAccount(studentAccount);
        this.studentCourseId.setSemester(semester);
    }
}
