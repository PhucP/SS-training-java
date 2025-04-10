package phucnh.qlbh.service.Impls;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phucnh.qlbh.exception.exceptions.NotFoundException;
import phucnh.qlbh.service.BaseService;

public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {
    protected final JpaRepository<T, ID> repository;
    protected final T type;

    public BaseServiceImpl(JpaRepository<T, ID> repository, T t) {
        this.repository = repository;
        this.type = t;
    }

    @Override
    public void add(T t) {
        //Todo: check duplicate onbject
        repository.save(t);
    }

    @Override
    public void delete(ID id) {
        T t = findById(id);
        repository.delete(t);
    }

    @Override
    public void update(ID id, T t) {
        T exitedT = findById(id);
        exitedT = t;
        repository.save(exitedT);
    }

    @Override
    public List<T> getAll() {
        List<T> listT = repository.findAll();
        if(listT.isEmpty() && listT.size() <= 0) {
            throw new RuntimeException(listT.getClass().getName() + "s is empty");
        } else return listT;
    }

    @Override
    public T findById(ID id) {
        T t = repository.findById(id).orElse(null);
        if(t == null) {
            throw new NotFoundException(type.getClass().getName() + " not found with this id");
        } else return t;
    }
}
