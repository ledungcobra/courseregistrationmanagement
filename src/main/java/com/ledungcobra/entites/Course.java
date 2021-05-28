package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ledungcobra.utils.Constants.COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK;

@Table(name = "course")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Course extends BaseEntity {

    @Id
    @Column(name = "COURSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    @ManyToOne
    private Subject subject;

    @Column(name = "THEORY_TEACHER_NAME", nullable = false)
    private String teacherName;

    @Column(name = "DAY_TO_STUDY_IN_WEEK")
    //, columnDefinition = "VARCHAR(255) CHARSET utf8 " + COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK, nullable = false)
    private String dayToStudyInWeek;

    @Column(name = "CLASSROOM_NAME", nullable = false)
    private String classroomName;

    @Column(name = "SHIFT_TO_STUDY_IN_DAY", nullable = false)
    private String shiftToStudyInDay;

    @Column(name = "NUMBER_OF_SLOT", nullable = false)
    private Integer numberOfSlot;


    @ManyToOne
    @JoinColumn(name = "SEMESTER_ID", nullable = false)
    private Semester semester;

    @ManyToMany
    @JoinTable(name = "STUDENT_SESSION_COURSE", joinColumns = @JoinColumn(name = "COURSE_ID",
            referencedColumnName = "COURSE_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    private List<StudentAccount> studentAccounts;


    public Course(Subject subject, String teacherName, String dayToStudyInWeek, String classroomName, String shiftToStudyInDay, Integer numberOfSlot, Semester semester) {
        this.subject = subject;
        this.teacherName = teacherName;
        this.dayToStudyInWeek = dayToStudyInWeek;
        this.classroomName = classroomName;
        this.shiftToStudyInDay = shiftToStudyInDay;
        this.numberOfSlot = numberOfSlot;
        this.semester = semester;
    }

    public Integer getCredit() {
        if (subject != null) {
            return subject.getCredit();
        }
        return null;
    }

    public String getSubjectName() {
        return this.subject.getName();
    }

}
