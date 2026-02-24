import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

void main(){
    Department department = new Department(1,"computer");
    Seller seller = new Seller(2,"Jhon", "jhon@gmail.com",new Date(),5000.0,department);
    SellerDao sellerDao = DaoFactory.createSellerDao();

    IO.println(seller);
}