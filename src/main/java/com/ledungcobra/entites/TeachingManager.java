package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teaching_manager")
@Getter
@Setter
public class TeachingManager extends User {

    @Id
    @Column(name = "TEACHING_MANAGER_ID")
    private String id;

    @Override
    public String getUserName() {
        return this.id;
    }
}
