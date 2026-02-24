package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "Select seller.* , department.name as DepName " +
                            "from seller inner join department " +
                            "on seller.departmentId = department.Id "  +
                            "where seller.id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("departmentId"));
                department.setName(resultSet.getString("DepName"));
                Seller seller = new Seller();
                seller.setId(resultSet.getInt("id"));
                seller.setName(resultSet.getString("Name"));
                seller.setEmail(resultSet.getString("Email"));
                seller.setBirthDate(resultSet.getDate("BirthDate"));
                seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
                seller.setDepartment(department);
                return seller;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closePreparedStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
