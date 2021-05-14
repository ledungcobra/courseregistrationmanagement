package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Class")
@Getter
@Setter
public class Class extends BaseEntity{

    @Id
    @Column(name = "CLASS_ID")
    private Long id;

    @Column(name = "CLASS_NAME")
    private String className;

    @ManyToOne
    @JoinColumn(name = "CREATED_BY", foreignKey = @ForeignKey(name = "FK_CLASS_TEACHING_MANAGER"))
    private TeachingManager createdBy;



}
