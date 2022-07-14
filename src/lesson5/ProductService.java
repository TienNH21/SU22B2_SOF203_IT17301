package lesson5;

import java.util.ArrayList;

public class ProductService {
    private ArrayList<Product> listProd;
    
    public ProductService()
    {
        this.listProd = new ArrayList<>();
    }
    
    public void insert(Product p)
    {
        this.listProd.add(p);
    }
    
    public void update(int id, Product p)
    {
        for (int i = 0; i < this.listProd.size(); i++) {
            Product prod = this.listProd.get(i);
            if (prod.getId() == id) {
                this.listProd.set(i, p);
            }
        }
    }
    
    public void delete(int id)
    {
        for (int i = 0; i < this.listProd.size(); i++) {
            Product prod = this.listProd.get(i);
            if (prod.getId() == id) {
                this.listProd.remove(i);
            }
        }
    }

    public ArrayList<Product> getList() {
        return listProd;
    }

    public void setList(ArrayList<Product> listProd) {
        this.listProd = listProd;
    }
}
