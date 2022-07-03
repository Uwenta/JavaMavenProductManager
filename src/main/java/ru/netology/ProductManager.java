package ru.netology;

public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.setRepo(repo);
    }

    public void add(Product product) {
        getRepo().save(product);
    }

    public Product[] searchBy(String text) {
        ProductRepository search = new ProductRepository();
        for (Product product : getRepo().getProducts()) {
            if (matches(product, text)) {
                search.save(product);
            }

        }
        return search.getProducts();
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }


    public void setRepo(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductRepository getRepo() {
        return repo;
    }

    public Product[] findAllProducts() {
        return getRepo().getProducts();
    }
}
