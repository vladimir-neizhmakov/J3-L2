package ru.geekbrains.spring.context.hw2;

import org.springframework.stereotype.Component;

@Component
public class ProductService{

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){this.productRepository = productRepository;}

    public int productCount(){
        return productRepository.getProducts().size();

    }

    public double productAverageCost(){
        double avg=0;
        for (Product p : productRepository.getProducts()) {
            avg += p.getCost();
        }
        avg /= productRepository.getProducts().size();
        return avg;
    }
}
