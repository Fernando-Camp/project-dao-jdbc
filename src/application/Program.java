import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

void main(){

    IO.println("===== Teste 1: seller findById =====");
    SellerDao sellerDao = DaoFactory.createSellerDao();
    Seller seller1 = sellerDao.findById(3);
    IO.println(seller1);
    IO.println();
    IO.println("===== Teste 2: seller findByDepartment =====");
    Department dep = new Department(1,null);
    List<Seller> seller2 = sellerDao.findByDepartment(dep);
    for (Seller seller : seller2) {
        IO.println(seller);
    }
}