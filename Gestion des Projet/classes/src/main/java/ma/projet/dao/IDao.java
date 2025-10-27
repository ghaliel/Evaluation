package ma.projet.dao;

import ma.projet.classes.EmployeTache;

import java.util.List;

public interface IDao<T> {
    boolean update(EmployeTache.EmployeTache o);

    boolean delete(EmployeTache.EmployeTache o);

    boolean create(T o);
    boolean update(T o);
    boolean delete(T o);
    T findById(int id);
    List<T> findAll();
}
