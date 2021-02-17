package ru.geekbrains.spring.context.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(hw2Config.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        System.out.println("Введите комманду:");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            String cmd[]=sc.nextLine().split(" ",4);
            if (cmd[0].equals("exit")) {exit=true;}
            if (cmd[0].equals("get")) {System.out.println(productService.getProductRepository().getProducts().toString());}
            if (cmd[0].equals("count")) {System.out.println(String.valueOf(productService.productCount()));}
            if (cmd[0].equals("avgcost")) {System.out.println(String.valueOf(productService.productAverageCost()));}
            if (cmd[0].equals("add")) {
                productService.getProductRepository().addProduct(new Product(cmd[1],Integer.parseInt(cmd[2])));
                System.out.println(productService.getProductRepository().getProducts().toString());
            }
            if (cmd[0].equals("delete")) {
                productService.getProductRepository().deleteProduct(productService.getProductRepository().getListID(Integer.parseInt(cmd[1])));
                System.out.println(productService.getProductRepository().getProducts().toString());
            }
            if (cmd[0].equals("update")) {
                productService.getProductRepository().updateProduct(productService.getProductRepository().getListID(Integer.parseInt(cmd[1])),cmd[2],Integer.parseInt(cmd[3]));
                System.out.println(productService.getProductRepository().getProducts().toString());
            }
        }
        context.close();
    }
}
