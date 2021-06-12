package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STUDENT_ACCOUNT", uniqueConstraints = {
        @UniqueConstraint(name = "UK_STUDENT_ACCOUNT1"
                , columnNames = {"STUDENT_INFO_ID", "EDUCATION_TYPE_ID"}
        ),
        @UniqueConstraint(name = "UK_STUDENT_ACCOUNT", columnNames = {"STUDENT_CARD_ID"})
})
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class StudentAccount extends User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "STUDENT_CARD_ID", nullable = false)
    private String studentCardId;

    @JoinColumn(name = "STUDENT_INFO_ID",
            referencedColumnName = "STUDENT_INFO_ID",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_STUDENT_ACCOUNT_STUDENT_INFO")
    )
    @ManyToOne(cascade = CascadeType.ALL)
    private StudentInfo studentInfo;

    @JoinColumn(name = "EDUCATION_TYPE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_STUDENT_ACCOUNT_EDUCATION_TYPE"))
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private EducationType educationType;

    @JoinColumn(name = "CLASS_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_ACCOUNT_CLASS"))
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Class studiedClass;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "STUDENT_ID",
                    foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE_STUDENT_ACCOUNT")),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID",
                    foreignKey = @ForeignKey(name = "FK_STUDENT_COURSE_COURSE"),
                    referencedColumnName = "COURSE_ID"))
    private List<Course> courses;

    public StudentAccount(String studentCardId,
                          StudentInfo studentInfo, EducationType educationType)
    {
        super(studentCardId);
        this.studentCardId = studentCardId;
        this.password = studentCardId;
        this.studentInfo = studentInfo;
        this.educationType = educationType;
    }

    public StudentAccount(String password, String studentCardId,
                          StudentInfo studentInfo,
                          EducationType educationType, Class studiedClass)
    {
        super(password);
        this.studentCardId = studentCardId;
        this.studentInfo = studentInfo;
        this.educationType = educationType;
        this.studiedClass = studiedClass;
    }


    @Override
    public void create()
    {
        super.create();
        this.password = studentCardId;
    }

    @Override
    public String getUserId()
    {
        return studentCardId;
    }

    @Override
    public String getFullName()
    {
        return this.studentInfo == null ? null : this.studentInfo.getFullName();
    }

    public String getStudyingCourses()
    {
        StringBuilder coursesStringBuilder = new StringBuilder();
        if (this.courses == null) return "";
        int length = this.courses.size();
        for (int i = 0; i < length; i++)
        {
            Course currentCourse = this.courses.get(i);

            if (currentCourse.getSemester() != null &&
                    currentCourse.getSemester().getActive())
            {
                coursesStringBuilder.append(currentCourse.getSubjectName());
                if (i < length - 1)
                {
                    coursesStringBuilder.append("\r\n");
                }
            }

        }
        return coursesStringBuilder.toString();

    }
}
