package bstorm.akimts.java.data_access;

import java.util.List;

public interface DAO<T, ID> {

    T get(ID id);
    List<T> getAll();
    boolean insert(T toInsert);
    void update(ID id, T toInsert);
    boolean delete(ID id);

}
