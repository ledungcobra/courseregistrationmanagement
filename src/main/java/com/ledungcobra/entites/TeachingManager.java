package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teaching_manager")
@Getter
@Setter
public class TeachingManager extends User{

    @Id
    @Column(name = "TEACHING_MANAGER_ID")
    private String id;

    @OneToMany(mappedBy = "manager")
    private List<TeachingManager> teachingManagers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "FK_CREATEDX_X"))
    private TeachingManager manager;

}
