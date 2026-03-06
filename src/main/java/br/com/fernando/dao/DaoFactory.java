package br.com.fernando.dao;

import br.com.fernando.dao.impl.DepartmentDaoJDBC;
import br.com.fernando.dao.impl.SellerDaoJDBC;
import br.com.fernando.db.DB;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
