package br.com.fernando.services;

import br.com.fernando.dao.DepartmentDao;
import br.com.fernando.model.entities.Department;

import java.util.List;

public class DepartmentService {

    private DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void insert(Department department) {
        departmentDao.insert(department);
    }

    public void update(Department department) {
        departmentDao.update(department);
    }
    public void deleteById(Integer id) {
        departmentDao.deleteById(id);
    }

    public Department findById(Integer id) {
        return departmentDao.findById(id);
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
