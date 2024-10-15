package src;

import java.util.ArrayList;

class Product{
    String name;
    double price;
    boolean isElectronic;
    private double discount = 0;

    public Product(String name, double price, boolean isElectronic){
        this.name = name;
        this.price = price;
        this.isElectronic = isElectronic;
        if(isElectronic){
            this.discount = price * 0.15;
        }
    }

    double getDiscount(){
        return discount;
    } 
}

class ShoppingCard{
    ArrayList<Product> productList = new ArrayList<>();
    double totalAmount = 0;
    double totalDiscount = 0;

    void addProduct (Product product){
        productList.add(product);
        totalAmount += product.price;
        totalDiscount += product.getDiscount();
    }

    void printInfo () {
        for(Product product : productList){
            System.out.println(product.name + " $" + product.price + " discount: " + product.getDiscount());
        }
        System.out.println("Total price without discount: " + totalAmount);
        System.out.println("Total discount: " + totalDiscount);
        System.out.println("Total amount: " + (totalAmount - totalDiscount));
    }
}

public class Main {
    public static void main(String[] args) {
        Product apple = new Product("Apple", 5, false);
        Product banana = new Product("Banana", 2, false);
        Product orange = new Product("Orange", 15, false);

        Product laptop = new Product("Laptop", 1500, true);
        Product tablet = new Product("Tablet", 500, true);
        Product smatphone = new Product("Smatphone", 1000, true);
        Product headPhones = new Product("HeadPhones", 100, true);

        ShoppingCard shoppingCard = new ShoppingCard();
        shoppingCard.addProduct(apple);
        shoppingCard.addProduct(orange);
        shoppingCard.addProduct(banana);
        shoppingCard.addProduct(tablet);
        shoppingCard.addProduct(tablet);
        shoppingCard.addProduct(headPhones);
        shoppingCard.addProduct(laptop);
        shoppingCard.addProduct(smatphone);
        shoppingCard.printInfo();
    }
}