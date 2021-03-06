package ru.netology;

public class ProductRepository {


    private Product[] products = new Product[0];

    public ProductRepository() {

    }

    public void save(Product product) {
        if (null == findById(product.getId())) {
            Product[] tmp = new Product[getProducts().length + 1];
            for (int i = 0; i < getProducts().length; i++) {
                tmp[i] = getProducts()[i];
            }
            tmp[tmp.length - 1] = product;
            setProducts(tmp);
        } else {
            throw new AlreadyExistsException("Product with ID: " + product.getId() + " already exists");

        }
    }

    public Product findById(int id) {
        for (Product product : products)
            if (product.getId() == id) {
                return product;
            }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");

        } else {
            Product[] tmp = new Product[getProducts().length - 1];
            int copyToIndex = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;
        }
    }


    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
