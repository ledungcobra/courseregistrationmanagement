package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity
{

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "isDeleted", columnDefinition = "TINYINT(1)")
    private Boolean isDeleted;


    @PrePersist
    public void create()
    {
        this.createdDate = new Date();
        this.isDeleted = false;
    }

    @PreUpdate
    public void update()
    {
        this.updatedDate = new Date();
    }

}
