package gb.spring.service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductRepository {
    List<Product> list = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init(){
        for (ProductSet product : ProductSet.values()) {
            list.add(new Product(product.ordinal()+1, product.toString(), product.getPrice()));
        }
    }

    public void addProduct(Product product){
      list.add(product);
    }

    public Product getProduct(int id){
        for (Product product : list) {
           if (product.getId() == id){
               return product;
           }
        }
        throw new IllegalArgumentException("ID введен неверно");
    }

    public List<Product> getList() {
        return list;
    }
}
