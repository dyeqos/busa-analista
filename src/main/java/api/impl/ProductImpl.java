package api.impl;

import api.dao.ProductRepository;
import api.dao.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProductImpl {

    @Inject
    ProductRepository productRepository;

    public List<Product> listProducts(){
        return productRepository.listAll();
    }
    public Product save(Product product){
        productRepository.persist(product);
        return product;
    }
}
