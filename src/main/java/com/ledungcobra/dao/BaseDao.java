package com.ledungcobra.dao;

import com.ledungcobra.entites.BaseEntity;
import com.ledungcobra.exception.NotHaveIdException;
import lombok.SneakyThrows;
import org.hibernate.Session;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

public abstract class BaseDao<E extends BaseEntity, ID extends Serializable>
{

    public static final String CANNOT_FIND_ID_ANNOTATION_IN_THIS_CLASS = "Cannot find Id annotation in this class";
    protected Session session;
    final Class<E> entityClass;

    protected BaseDao(Session session)
    {
        this.session = session;
        entityClass = ((Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public E findById(ID id)
    {
        return session.get(entityClass, id);
    }

    public List<E> findAll()
    {
        return (List<E>) session.createQuery("from " + entityClass.getSimpleName()).getResultList();
    }

    @SneakyThrows
    public void deleteById(ID id)
    {
        Field[] fields = entityClass.getFields();

        boolean foundIdAnnotation = false;
        for (Field field : fields)
        {

            Annotation idAnnotation = field.getAnnotation(Id.class);
            field.setAccessible(true);
            if (Objects.nonNull(idAnnotation))
            {
                session.createQuery("delete from " + entityClass.getSimpleName() + " where +" + field.getName() + "=?1");
                foundIdAnnotation = true;
            }

        }

        if (!foundIdAnnotation)
        {
            throw new NotHaveIdException(CANNOT_FIND_ID_ANNOTATION_IN_THIS_CLASS);
        }
    }

    public void deleteByObject(E obj)
    {
        session.delete(obj);
    }

    public E save(E obj)
    {
        session.save(obj);
        return obj;
    }

    public E update(E obj)
    {
        session.update(obj);
        return obj;
    }

    public void saveOrUpdate(E obj)
    {
        session.saveOrUpdate(obj);
    }
}