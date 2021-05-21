package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

import static com.ledungcobra.utils.Constants.COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK;

@Table(name = "course")
@Entity
@Getter
@Setter
public class Course extends BaseEntity {

    @Id
    @Column(name = "COURSE_ID")
    private String id;

    @JoinColumn(name = "SUBJECT_ID",nullable = false)
    @ManyToOne
    private  Subject subject;

    @Column(name = "COURSE_CREDIT",nullable = false)
    private Integer credit;

    @Column(name = "THEORY_TEACHER_NAME",nullable = false)
    private String teacherName;

    @Column(name = "DAY_TO_STUDY_IN_WEEK", columnDefinition = "VARCHAR(255) CHARSET utf8 "+COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK,nullable = false)
    private String dayToStudyInWeek;

    @Column(name = "CLASSROOM_NAME",nullable = false)
    private String classroomName;

    @Column(name = "SHIFT_TO_STUDY_IN_DAY",nullable = false)
    private String shiftToStudyInDay;

    @Column(name = "NUMBER_OF_SLOT", nullable = false)
    private Integer numberOfSlot;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "COURSE_SEMESTER",joinColumns = @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = { @JoinColumn(name = "SEMESTER_NAME"), @JoinColumn(name = "YEAR")}
    )

    private List<Semester> semesters;

    public String getSubjectName(){
        return this.subject.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(subject, course.subject) && Objects.equals(credit, course.credit) && Objects.equals(teacherName, course.teacherName) && Objects.equals(dayToStudyInWeek, course.dayToStudyInWeek) && Objects.equals(classroomName, course.classroomName) && Objects.equals(shiftToStudyInDay, course.shiftToStudyInDay) && Objects.equals(numberOfSlot, course.numberOfSlot) && Objects.equals(semesters, course.semesters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, subject, credit, teacherName, dayToStudyInWeek, classroomName, shiftToStudyInDay, numberOfSlot, semesters);
    }
}
