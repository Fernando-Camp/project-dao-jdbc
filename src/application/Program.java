import model.dao.DaoFactory;
import model.dao.SellerDao;

void main(){

//    Department department = new Department(1,"computer");
//    Seller seller = new Seller(2,"Jhon", "jhon@gmail.com",new Date(),5000.0,department);
      SellerDao sellerDao = DaoFactory.createSellerDao();

      IO.println(sellerDao.findById(3));
}