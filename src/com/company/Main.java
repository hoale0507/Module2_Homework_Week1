package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Product product1 = new Product(1, "Iphone 13", 1000, "First product");
        Product product2 = new Product(2, "Samsung A7", 600, "Second product");
        Product product3 = new Product(3, "Iphone X", 300, "Third product");
        Product[] products = {product1, product2, product3};
        System.out.println("Original product list:");
        display(products);
        System.out.println();
        Product product4 = new Product(4, "Samsung A10", 1000, "Newest product");
        Product[] newProducts1 = addProduct(products, 0, product4);
        System.out.println("Product list after adding a new product:");
        display(newProducts1);
        System.out.println();
        Product[] newProducts2 = removeProduct(products, 0);
        System.out.println("Product list after removing 1st product:");
        display(newProducts2);
        System.out.println();
        sort(products);
        System.out.println("Product list after sort alphabet:");
        display(products);
        System.out.println();
        update(products, 2, 5, "Oppo", 500, "Hot trend product");
        System.out.println("Product list after update");
        display(products);
    }

    public static void display(Product[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static Product[] addProduct(Product[] arr, int index, Product product) {
        Product[] newProducts = new Product[arr.length + 1];
        for (int i = 0; i < arr.length+1; i++) {
            if (i < index) {
                newProducts[i] = arr[i];
            } else if (i == index) {
                newProducts[i] = product;
            } else {
                newProducts[i] = arr[i - 1];
            }
        }
        return newProducts;
    }

    public static Product[] removeProduct(Product[] arr, int index) {
        Product[] newProducts = new Product[arr.length - 1];
        for (int i = 0; i < arr.length-1; i++) {
            if (i < index) {
                newProducts[i] = arr[i];
            } else {
                newProducts[i] = arr[i + 1];
            }
        }
        return newProducts;
    }

    public static int findProduct(Product[] arr, String name) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getName() == name) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void sort(Product[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].getName().compareTo(arr[j].getName()) > 0) {
                    Product temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void update(Product[] arr, int index, int id, String name, long price, String description) {
        arr[index].setId(id);
        arr[index].setName(name);
        arr[index].setPrice(price);
        arr[index].setDescription(description);
    }

//    public static void show(Product[]arr){
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
}
