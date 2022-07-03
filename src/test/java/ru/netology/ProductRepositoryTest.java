package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product product1 = new Product(1, "тетрадь", 55);
    Product product2 = new Product(2, "шариковая ручка", 15);
    Book product3 = new Book(3, "гарри поттер и орден феникса", 700, "джоан роулинг");
    Smartphone product4 = new Smartphone(4, "samsung A-01", 7000, "samsung ltd, china");
    Product product5 = new Product(5, "стул", 8000);
    Product product6 = new Product(6, "стул", 5000);


    @Test
    public void shouldSaveProduct() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Product expected = product3;
        Product actual = repo.findById(3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindByIdImpossible() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Product expected = null;
        Product actual = repo.findById(8);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        repo.removeById(1);
        repo.removeById(6);

        Product[] expected = {product2, product3, product4, product5};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveByIdImpossible() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        repo.removeById(7);

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }


}
