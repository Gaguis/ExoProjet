package be.isib.dao.hibernate;

import be.isib.dao.EntityDao;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class DefaultHibernateDao<E> implements EntityDao<E>{

    @PersistenceContext(unitName="persistenceUnit")
    protected EntityManager entityManager;

    protected E instance;
    private Class<E> entityClass;

    @Transactional
    public void persist(E e) throws HibernateException {
        getEntityManager().persist(e);
    }
    @Transactional
    public void merge(E e) throws HibernateException{
        getEntityManager().merge(e);
    }
    @Transactional
    public void remove(Object id) throws Exception{
        getEntityManager().remove((E)getEntityManager().find(getEntityClass(), id));
    }


    @Transactional(readOnly = true)
    public E findById(Object id) throws Exception {
        return (E)getEntityManager().find(getEntityClass(), id);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<E> findAll() throws Exception{
        return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t").getResultList();
    }

    @Transactional(readOnly = true)
    public long count() throws Exception {
        return (Long) getEntityManager().createQuery("Select count(t) from " + getEntityClass().getSimpleName() + " t").getSingleResult();
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }



    public void setEntityManager(EntityManager entityManager) throws Exception{
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    public Class<E> getEntityClass() throws Exception{
        if (entityClass == null) {
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType)
            {
                ParameterizedType paramType = (ParameterizedType) type;
                if (paramType.getActualTypeArguments().length == 2) {
                    if (paramType.getActualTypeArguments()[1] instanceof TypeVariable) {
                        throw new IllegalArgumentException(
                                "Can't find class using reflection");
                    }
                    else {
                        entityClass = (Class<E>) paramType.getActualTypeArguments()[1];
                    }
                } else {
                    entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
                }
            } else {
                throw new Exception("Can't find class using reflection");
            }
        }
        return entityClass;
    }

}
