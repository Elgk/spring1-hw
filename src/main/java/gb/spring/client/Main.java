package gb.spring.client;

import gb.spring.service.Cart;
import gb.spring.service.ProductRepository;
import gb.spring.service.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        final ProductRepository productRepository = context.getBean(ProductRepository.class);
        final Cart cart = context.getBean(Cart.class);

        final Scanner scanner = new Scanner(System.in);
        productRepository.getList().stream().forEach(System.out::println);
        System.out.println("_______________");
        System.out.println("Команды: ");
        System.out.println("ADD - добавить товар в корзину");
        System.out.println("DELETE - удалить товар из корзины");
        System.out.println("EXIT - выход");
        System.out.println("Введите команду:");
        while (true) {
            final String str = scanner.nextLine();
            if ("ADD".equals(str) ) {
                System.out.println("Введите id товара");
                int productID = scanner.nextInt();
                cart.addProduct(productRepository.getProduct(productID));
                System.out.println(cart.toString());
            }
            if ( "DELETE".equals(str)){
                System.out.println("Введите id товара");
                int productID = scanner.nextInt();
                cart.removeProduct(productRepository.getProduct(productID));
                System.out.println(cart.toString());
            }
            if ("EXIT".equals(str)) {
                return;
            }
        }
    }
}
