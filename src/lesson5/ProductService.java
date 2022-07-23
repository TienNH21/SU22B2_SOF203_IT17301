package lesson5;

import java.util.ArrayList;

public class ProductService {
    private ProductRepository prodRepo;
    
    public ProductService()
    {
        this.prodRepo = new ProductRepository();
    }
    
    public void insert(Product p)
    {
        this.prodRepo.insert(p);
    }
    
    public void update(int id, Product p)
    {
        this.prodRepo.update(id, p);
    }
    
    public void delete(int id)
    {
        this.prodRepo.delete(id);
    }

    public ArrayList<Product> getList() {
        return this.prodRepo.all();
    }
}
