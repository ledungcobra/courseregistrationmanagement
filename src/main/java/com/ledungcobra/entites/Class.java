package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Class")
@Getter
@Setter
public class Class extends BaseEntity{

    @Id
    @Column(name = "CLASS_ID")
    private Long id;

    @Column(name = "CLASS_NAME",unique = true)
    private String className;

    @ManyToOne
    @JoinColumn(name = "CREATED_BY", foreignKey = @ForeignKey(name = "FK_CLASS_TEACHING_MANAGER"))
    private TeachingManager createdBy;

    @OneToMany(mappedBy = "studiedClass",fetch = FetchType.LAZY)
    private List<Student> students;

}
