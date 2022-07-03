package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product product1 = new Product(1, "тетрадь", 55);
    Product product2 = new Product(2, "шариковая ручка", 15);
    Book product3 = new Book(3, "гарри поттер и орден феникса", 700, "джоан роулинг");
    Smartphone product4 = new Smartphone(4, "samsung A-01", 7000, "samsung ltd, china");


    @Test
    public void shouldMatchesName() {
        boolean expected = product1.matches("тетрадь");
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesNameBook() {
        boolean expected = product2.matches("ручка");
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMaker() {
        boolean expected = product4.matches("ltd");
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesAuthor() {
        boolean expected = product3.matches("джоан роулинг");
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesNameFalse() {
        boolean expected = product1.matches("стул");
        boolean actual = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMakerFalse() {
        boolean expected = product4.matches("стул");
        boolean actual = false;

        Assertions.assertEquals(expected, actual);
    }
}
