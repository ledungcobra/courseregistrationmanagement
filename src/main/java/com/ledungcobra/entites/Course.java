package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static com.ledungcobra.utils.Constants.COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK;

@Table(name = "course")
@Entity
@Getter
@Setter
public class Course extends BaseEntity {

    @Id
    @Column(name = "COURSE_ID")
    private String id;

    @Column(name = "SUBJECT_ID",nullable = false)
    private String subjectId;

    @Column(name = "COURSE_CREDIT",nullable = false)
    private Integer credit;

    @Column(name = "THEORY_TEACHER_NAME",nullable = false)
    private String teacher;

    @Column(name = "DAY_TO_STUDY_IN_WEEK", columnDefinition = "VARCHAR(255) CHARSET utf8 "+COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK,nullable = false)
    private String dateToStudyInWeek;

    @Column(name = "CLASSROOM_NAME",nullable = false)
    private String classroomName;

    @Column(name = "SHIFT_TO_STUDY_IN_DAY",nullable = false)
    private String shiftToStudyInDay;

    @Column(name = "NUMBER_OF_SLOT", nullable = false)
    private Integer numberOfSlot;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "COURSE_SEMESTER",joinColumns = @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "SEMESTER_ID")
    )

    private List<Semester> semesters;
}
