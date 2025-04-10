package phucnh.qlbh.controller;

import java.util.List;

import phucnh.qlbh.service.BaseService;

public abstract class BaseController<T, ID> {
    protected final BaseService<T, ID> service;

    public BaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    public List<T> findAll() {
        return service.getAll();
    }

    public void delete(ID id) {
        service.delete(id);
    }

    public T findById(ID id) {
        return service.findById(id);
    }
}
