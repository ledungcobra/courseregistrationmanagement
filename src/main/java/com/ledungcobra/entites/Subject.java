package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
@Getter
@Setter
public class Subject extends BaseEntity{

    @Id
    @Column(name = "SUBJECT_ID",nullable = false)
    private String id;

    @Column(name = "SUBJECT_NAME",unique = true)
    private String name;

    @Column(name = "SUBJECT_CREDIT", nullable = false)
    private Integer credit;

}
