package cesur.dam.g1.data;

import cesur.dam.g1.models.Equipo;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<Equipo> findById(Long id);
    List<T> findAll();

    T save(T entity);
    Equipo update(T entity);
    void deleteById(Long id);





}
