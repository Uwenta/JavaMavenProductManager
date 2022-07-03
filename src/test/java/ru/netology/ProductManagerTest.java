package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "тетрадь", 55);
    Product product2 = new Product(2, "шариковая ручка", 15);
    Book product3 = new Book(3, "гарри поттер и орден феникса", 700, "джоан роулинг");
    Smartphone product4 = new Smartphone(4, "samsung A-01", 7000, "samsung ltd, china");
    Product product5 = new Product(5, "стул", 8000);
    Product product6 = new Product(6, "стул", 5000);

    @Test
    public void shouldAddProduct() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product5);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = {product1, product2, product5, product3, product4};
        Product[] actual = manager.findAllProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNamePartName() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product5);
        manager.add(product3);
        manager.add(product4);
        manager.add(product6);


        Product[] expected = {product3};
        Product[] actual = manager.searchBy("гарри поттер");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameTwoProduct() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product5);
        manager.add(product3);
        manager.add(product4);
        manager.add(product6);


        Product[] expected = {product5, product6};
        Product[] actual = manager.searchBy("стул");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByMaker() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product5);
        manager.add(product3);
        manager.add(product4);
        manager.add(product6);


        Product[] expected = {product4};
        Product[] actual = manager.searchBy("china");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product5);
        manager.add(product3);
        manager.add(product4);
        manager.add(product6);


        Product[] expected = {product3};
        Product[] actual = manager.searchBy("роулинг");

        Assertions.assertArrayEquals(expected, actual);
    }

}
