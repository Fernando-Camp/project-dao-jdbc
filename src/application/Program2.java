import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

void main() {
    IO.println("=-=-=-=[Teste 01]: Insert Implementation-=-=-=-=-=\n");
    DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
    Department department = new Department(null, "Food");
    departmentDao.insert(department);
    IO.println(department);
    IO.println();
    IO.println("=-=-=-=[Teste 02]: Update Implementation-=-=-=-=-=\n");
    department.setName("Photography");
    departmentDao.update(department);
    IO.println();
    IO.println("=-=-=-=[Teste 03]: DeleteById Implementation-=-=-=-=-=\n");
    departmentDao.deleteById(13);
    IO.println();
    IO.println("=-=-=-=[Teste 04]: FindById Implementation-=-=-=-=-=\n");
    department = departmentDao.findById(9);
    IO.println(department);
    IO.println();
    IO.println("=-=-=-=[Teste 05]: FindAll Implementation-=-=-=-=-=\n");
    departmentDao.findAll().forEach(System.out::println);
}