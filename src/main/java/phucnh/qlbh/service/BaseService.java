package phucnh.qlbh.service;

import java.util.List;

public interface BaseService<T, ID> {
    public void add(T t);
    public void delete(ID id);
    public void update(ID id, T t);
    public List<T> getAll();
    public T findById(ID id);
}
