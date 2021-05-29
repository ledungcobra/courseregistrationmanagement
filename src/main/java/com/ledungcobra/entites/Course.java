package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.plugin2.message.WindowActivationEventMessage;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ledungcobra.utils.Constants.COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK;

@Table(name = "COURSE")
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


    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "COURSE_ID",
            referencedColumnName = "COURSE_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    private List<StudentAccount> studentAccounts;

    @ManyToOne
    @JoinColumn(name = "COURSE_INFO_ID")
    private CourseInfo courseInfo;

    public Course(CourseInfo courseInfo, String teacherName, String dayToStudyInWeek, String classroomName, String shiftToStudyInDay, Integer numberOfSlot) {
        this.courseInfo = courseInfo;
        this.teacherName = teacherName;
        this.dayToStudyInWeek = dayToStudyInWeek;
        this.classroomName = classroomName;
        this.shiftToStudyInDay = shiftToStudyInDay;
        this.numberOfSlot = numberOfSlot;
    }

    public Integer getCredit() {
        if (courseInfo != null && courseInfo.getSubject() != null) {
            return courseInfo.getSubject().getCredit();
        }
        return null;
    }

    public String getSubjectName() {
        if (courseInfo != null && courseInfo.getSubject() != null) {
            return courseInfo.getSubject().getName();
        }
        return null;
    }

    public Subject getSubject() {
        return courseInfo != null ? courseInfo.getSubject() : null;
    }

    public void setSubject(Subject subject) {
        if (courseInfo != null) courseInfo.setSubject(subject);
    }

    public Semester getSemester() {
        if (courseInfo != null) {
            return courseInfo.getSemester();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", " + "Subject name: " + this.getSubjectName();
    }
}
