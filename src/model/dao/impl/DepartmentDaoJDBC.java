package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection connection;

    public DepartmentDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into department (name)" +
                    "values (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, department.getName());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    department.setId(resultSet.getInt(1));
                }
            }
            else {
                throw new DbException("Department insert failed");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update department set name=? where id=?", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getId());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                IO.println("Update department successfully!");
            }
            else {
                throw new DbException("Department update failed");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from department where id=?",  PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                IO.println("Delete department successfully!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        try {
            prepareStatement = connection.prepareStatement("select * from department where id= ?");
            prepareStatement.setInt(1, id);
            resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                Department department = new Department(resultSet.getInt("Id"), resultSet.getString("Name"));
                return department;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(prepareStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Department> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Department> departments = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from department");
            while(resultSet.next()) {
                Department department = new Department(resultSet.getInt("Id"), resultSet.getString("Name"));
                departments.add(department);
            }
            return departments;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
    }

}
