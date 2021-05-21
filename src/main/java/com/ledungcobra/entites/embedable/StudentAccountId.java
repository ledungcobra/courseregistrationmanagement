package com.ledungcobra.entites.embedable;

import com.ledungcobra.entites.EducationType;
import com.ledungcobra.entites.StudentInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class StudentAccountId implements Serializable {

    @JoinColumn(name = "STUDENT_INFO_ID",
            referencedColumnName = "STUDENT_INFO_ID")
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private StudentInfo studentInfo;

    @JoinColumn(name = "EDUCATION_TYPE_ID")
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private EducationType educationType;

    public StudentAccountId(StudentInfo studentInfo, EducationType educationType) {
        this.studentInfo = studentInfo;
        this.educationType = educationType;
    }

    public StudentAccountId() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAccountId that = (StudentAccountId) o;
        return Objects.equals(studentInfo, that.studentInfo) && Objects.equals(educationType, that.educationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentInfo, educationType);
    }
}
    