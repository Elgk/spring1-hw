package gb.spring.service;

public enum ProductSet {
    MILK(50),
    CHESSE(750),
    BUTTER(600),
    PASTA(80),
    SUGAR(45);

    private int price;

    public int getPrice() {
        return price;
    }

    ProductSet(){};

    ProductSet(int price) {
        this.price = price;
    }
}
