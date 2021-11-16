package ru.khorolskiy.level_3.lesson_3;

import org.springframework.stereotype.Component;
import ru.khorolskiy.level_3.lesson_3.Models.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {
    private List<Product> repo;

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(repo);
    }

    public Product getProduct(int id) {
        return repo.stream().filter(l -> l.getId() == id).findFirst().orElseThrow(() -> new RuntimeException());
    }

    @PostConstruct
    public void addProducts(){
        repo = new ArrayList(List.of(
                new Product(1L, "Apple", 25),
                new Product(2L, "Papaya", 79),
                new Product(3L, "Cherry", 85),
                new Product(4L, "Bread", 43))
        );
    }
}

