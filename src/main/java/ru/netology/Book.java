package ru.netology;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.setAuthor(author);
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getAuthor().contains(search);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
