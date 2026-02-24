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
    Department dep1 = new Department(1,null);
    List<Seller> seller2 = sellerDao.findByDepartment(dep1);
    for (Seller seller : seller2) {
        IO.println(seller);
    }
    IO.println();
    IO.println("===== Teste 3: seller findByDepartment =====");
    List<Seller> seller3 = sellerDao.findAll();
    for (Seller seller : seller3) {
        IO.println(seller);
    }
    IO.println();
    IO.println("===== Teste 4: seller findByDepartment =====");
    Seller  seller4 = new Seller(null, "Lucas", "lucas@gmail.com", new Date(), 1500.0,dep1);
    sellerDao.insert(seller4);
    IO.println("Inserted seller successfully! Seller id = " + seller4.getId());
}