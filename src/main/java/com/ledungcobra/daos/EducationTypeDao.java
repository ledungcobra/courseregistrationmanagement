package com.ledungcobra.daos;

import com.ledungcobra.entites.EducationType;
import org.hibernate.Session;

public class EducationTypeDao extends BaseDao<EducationType, Long>
{

    public EducationTypeDao(Session session)
    {
        super(session);
    }

}
