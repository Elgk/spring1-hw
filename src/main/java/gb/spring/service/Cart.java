package gb.spring.service;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cart = new HashMap<>();

    public Map<Product, Integer> getCart() {
        return cart;
    }
    public void addProduct(Product product){
        int qnt = cart.getOrDefault(product,0);
        cart.put(product, qnt + 1);
    }

    public void removeProduct(Product product){
        int qnt = cart.get(product);
        if (qnt - 1 == 0){
            cart.remove(product);
        }else {
            cart.put(product, qnt - 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
 /*       cart.forEach((k, v)->{
           long sum = k.getCost() * v;
           sb.append(k.getTitle()).append(", ").append(k.getCost()).append("р, ").append("кол-во ").append(v).append(", сумма " +sum);
           sb.append(System.lineSeparator());
        });*/
        long totalSum = 0;
        for (Map.Entry<Product, Integer> entry: cart.entrySet() ) {
            long price = entry.getKey().getCost();
            int qnt = entry.getValue();
            long sum =  price * qnt;
            String title = entry.getKey().getTitle();
            sb.append(title).append(", ").append(price).append("р, ").append("кол-во ").append(qnt).append(", сумма " +sum);
            sb.append(System.lineSeparator());
            totalSum += (entry.getKey().getCost() * entry.getValue());
        }
        sb.append("итого: " + totalSum);
        return sb.toString();
//        return "Cart{" +
//                "cart=" + cart +
//                '}';
    }
}
