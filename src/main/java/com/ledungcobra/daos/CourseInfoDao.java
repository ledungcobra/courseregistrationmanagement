package com.ledungcobra.daos;

import com.ledungcobra.entites.CourseInfo;
import org.hibernate.Session;

public class CourseInfoDao extends BaseDao<CourseInfo, Long>
{
    public CourseInfoDao(Session session)
    {
        super(session);
    }
}
