package br.com.fernando.services;

import br.com.fernando.dao.SellerDao;
import br.com.fernando.model.entities.Department;
import br.com.fernando.model.entities.Seller;

import java.util.List;

public class SellerService {

    private SellerDao sellerDao;

    public SellerService(SellerDao sellerDao) {
        this.sellerDao = sellerDao;
    }

    public void insert(Seller seller) {
        sellerDao.insert(seller);
    }

    public void update(Seller seller) {
        sellerDao.update(seller);
    }
    public void deleteById(Integer id) {
        sellerDao.deleteById(id);
    }

    public Seller findById(Integer id) {
        return sellerDao.findById(id);
    }

    public List<Seller> findAll() {
        return sellerDao.findAll();
    }

    public List<Seller> findByDepartment(Department department) {
        return sellerDao.findByDepartment(department);
    }
}
