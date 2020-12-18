package com.example.sqlserver.sqlserver;

import com.example.sqlserver.sqlserver.model.Product;
import com.example.sqlserver.sqlserver.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SqlserverApplication implements CommandLineRunner {

    private ProductRepository productRepository;


    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private Logger LOG = LoggerFactory.getLogger(SqlserverApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SqlserverApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Product product1 = new Product();
        Product product2 = new Product();

        product1.setName("Tester Product");
        product1.setDescription("This is a tester product");
        product1.setCategory("TEST");
        product1.setType("GENERAL");
        product1.setPrice(0.0);

        product2.setName("Another Tester Product");
        product2.setDescription("This is a tester product");
        product2.setCategory("TEST");
        product2.setType("CUSTOM");
        product2.setPrice(15.0);

        Product product3 = new Product();
        product3.setName("Tester Product");
        product3.setDescription("description");
        product3.setCategory("TEST");
        product3.setType("SPECIFIC");
        product3.setPrice(19.0);

/*        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);*/

        List<Product> products = productRepository.findAll();
        for(Product product : products) {
            LOG.info("Products found: " + product.toString());
        }


    }

}
