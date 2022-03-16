package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest1 {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Smartphone firstPhone = new Smartphone(1, "Realme", 15_000, "Xiaomi");
    private Smartphone secondPhone = new Smartphone(1, "Realme", 15_000, "Xiaomi");


    @BeforeEach
    void setUp() {
        manager.add(firstPhone);
        manager.add(secondPhone);
    }

    @Test
    void shouldDisplaySeveralSuitableProducts() {
        Product firstPhone = new Product(1, "Realme", 15_000);
        Product secondPhone = new Product(1, "Realme", 15_000);
        assertEquals(firstPhone, secondPhone);
    }
}