package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT_INFO",
        uniqueConstraints =
        @UniqueConstraint(name = "UK_STUDENT_INFO",
                columnNames = {"IDENTITY_CARD_NUMBER"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class StudentInfo extends BaseEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_INFO_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "GENDER", columnDefinition = "varchar(255) CHECK(GENDER IN('Boy','Girl'))")
    private String gender;

    @Column(name = "BIRTHDAY")
    private Date birthdate;

    @Column(name = "IDENTITY_CARD_NUMBER", nullable = false)
    private String identityCardNumber;

    @OneToMany(mappedBy = "studentInfo")
    private List<StudentAccount> studentAccount;

    @Column(name = "FULL_NAME", columnDefinition = "VARCHAR(255) CHARSET utf8")
    protected String fullName;

    public StudentInfo(String gender, Date birthdate, String identityCardNumber, String fullName)
    {
        this.gender = gender;
        this.birthdate = birthdate;
        this.identityCardNumber = identityCardNumber;
        this.fullName = fullName;
    }
}
