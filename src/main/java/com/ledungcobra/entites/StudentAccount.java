package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "STUDENT_ACCOUNT", uniqueConstraints = {
        @UniqueConstraint(name = "UK_STUDENT_ACCOUNT"
                , columnNames = {"STUDENT_INFO_ID", "EDUCATION_TYPE_ID"}
        )
})
@Getter
@Setter
public class StudentAccount extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Long id;

    @Column(name = "STUDENT_CARD_ID", nullable = false, unique = true)
    private String studentCardId;

    @JoinColumn(name = "STUDENT_INFO_ID",
            referencedColumnName = "STUDENT_INFO_ID", nullable = false)
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private StudentInfo studentInfo;

    @JoinColumn(name = "EDUCATION_TYPE_ID", nullable = false)
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private EducationType educationType;

    public StudentAccount(String studentCardId, String fullName,
                          StudentInfo studentInfo, EducationType educationType) {
        super(fullName, studentCardId);
        this.studentCardId = studentCardId;
        this.password = studentCardId;
        this.studentInfo = studentInfo;
        this.educationType = educationType;
    }

    @JoinColumn(name = "CLASS_ID")
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Class studiedClass;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE_SEMESTER",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = {
                    @JoinColumn(name = "COURSE_ID"),
                    @JoinColumn(name = "SEMESTER_NAME"),
                    @JoinColumn(name = "YEAR")
            }
    )
    private List<CourseSemester> courseSemesters;


    public StudentAccount() {
    }

    @Override
    public void create() {
        super.create();
        this.password = studentCardId;
    }

    @Override
    public String getUserName() {
        return studentCardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentAccount that = (StudentAccount) o;
        return Objects.equals(id, that.id) && Objects.equals(studentCardId, that.studentCardId) && Objects.equals(studentInfo, that.studentInfo) && Objects.equals(educationType, that.educationType) && Objects.equals(studiedClass, that.studiedClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, studentCardId, studentInfo, educationType, studiedClass);
    }

    public String getStudyingCourses() {
        StringBuilder courses = new StringBuilder();
        int length = this.courseSemesters.size();
        for (int i = 0; i < length; i++) {
            CourseSemester currentCourseSemester = this.courseSemesters.get(i);

            if (currentCourseSemester.getSemester().getActive()) {
                courses.append(currentCourseSemester.getCourse().getSubjectName());
                if (i < length - 1) {
                    courses.append(", ");
                }
            }

        }
        return courses.toString();

    }
}
