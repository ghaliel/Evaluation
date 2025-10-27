package ma.projet.dao;

import java.util.List;

public interface IDao<T> {
    T create(T o);
    T update(T o);
    boolean delete(T o);
    T findById(Long id);
    List<T> findAll();
}

