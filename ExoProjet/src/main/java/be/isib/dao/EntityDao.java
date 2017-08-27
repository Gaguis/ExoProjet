package be.isib.dao;

import java.util.List;

public interface EntityDao<E> {

    void persist(E e) throws Exception;

    void merge(E e) throws Exception;

    void remove(Object id) throws Exception;

    E findById(Object id) throws Exception;

    List<E> findAll() throws Exception;

    long count() throws Exception;


}
