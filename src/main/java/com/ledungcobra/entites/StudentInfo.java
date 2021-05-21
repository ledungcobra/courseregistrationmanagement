package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Student_Info")
@Getter
@Setter
public class StudentInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_INFO_ID")
    private Long id;

    public StudentInfo(String gender, Date date, String identityCardNumber) {
        this.gender = gender;
        this.birthdate = date;
        this.identityCardNumber = identityCardNumber;
    }

    @Column(name = "GENDER", columnDefinition = "varchar(255) CHECK(GENDER IN('Boy','Girl'))")
    private String gender;

    @Column(name = "BIRTHDAY")
    private Date birthdate;

    @Column(name = "IDENTITY_CARD_NUMBER", unique = true, nullable = false)
    private String identityCardNumber;

    @OneToMany
    private List<StudentAccount> studentAccount;

    public StudentInfo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentInfo that = (StudentInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(gender, that.gender) && Objects.equals(birthdate, that.birthdate) && Objects.equals(identityCardNumber, that.identityCardNumber) && Objects.equals(studentAccount, that.studentAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, gender, birthdate, identityCardNumber, studentAccount);
    }
}
