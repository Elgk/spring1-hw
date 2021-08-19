package gb.spring.service.context;

import gb.spring.service.Cart;
import gb.spring.service.Product;
import gb.spring.service.ProductRepository;

public class Container {
    private Product product;
    private ProductRepository productRepository;
    private Cart cart;

    public Container() {
        this.product = new Product();
        this.productRepository = new ProductRepository();
        this.cart = new Cart();
    }
}
