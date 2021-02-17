package ru.geekbrains.spring.context.hw2;

import java.util.List;

public interface ProductRepositoryInterface {
    List<Product> getProducts();
    void addProduct(Product product);
    void updateProduct(int id, String newtitle, int newcost);
    void deleteProduct(int id);
}
