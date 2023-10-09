package dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DataRespository<T> {

    List<T> findAll();
    Optional<T> findById(String tId);
    boolean save(T t) throws IOException;
    boolean deleteById(String tId) throws IOException;
    void saveAll() throws IOException;
    default void sort() {}
}
