package com.ledungcobra.entites.embedable;

import com.ledungcobra.entites.Course;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.StudentAccount;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class StudentCourseSemesterId implements Serializable {

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumns(value = {
            @JoinColumn(name = "STUDENT_INFO_ID"),
            @JoinColumn(name = "EDUCATION_TYPE_ID")},
            foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE_SEMESTER_To_STUDENT"))
    private StudentAccount student;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumns({@JoinColumn(name = "SEMESTER_NAME"),
            @JoinColumn(name = "YEAR")})
    private Semester studentCourseSemester;


    public StudentCourseSemesterId(StudentAccount student, Course course, Semester studentCourseSemester) {
        this.student = student;
        this.course = course;
        this.studentCourseSemester = studentCourseSemester;
    }

    public StudentCourseSemesterId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseSemesterId that = (StudentCourseSemesterId) o;
        return Objects.equals(student, that.student) && Objects.equals(course, that.course) && Objects.equals(studentCourseSemester, that.studentCourseSemester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course, studentCourseSemester);
    }
}
