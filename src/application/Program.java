import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

void main(){

//    Department department = new Department(1,"computer");
//    Seller seller = new Seller(2,"Jhon", "jhon@gmail.com",new Date(),5000.0,department);
    IO.println("===== Teste 1: seller findById =====");
    SellerDao sellerDao = DaoFactory.createSellerDao();
    Seller seller = sellerDao.findById(3);

    IO.println(seller);
}