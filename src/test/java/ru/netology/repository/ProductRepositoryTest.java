package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Smartphone firstPhone = new Smartphone(1, "Realme", 15_000, "Xiaomi");
    private Smartphone secondPhone = new Smartphone(2, "Apple", 50_000, "Apple");
    private Smartphone thirdPhone = new Smartphone(3, "BQ", 8_000, "Mundo Reader");


    void setUp() {
        repository.save(firstPhone);
        repository.save(secondPhone);
        repository.save(thirdPhone);
    }


    @Test
    void shouldSave() {
        setUp();
        repository.save(new Smartphone(4, "NOKIA", 25_000, "Nokia Corporation"));
        int expected = 4;
        Product[] actual = repository.findAll();
    }

    @Test
    void shouldFindAll() {
        setUp();
        int expected = 3;
        Product[] actual = repository.findAll();
        assertEquals(expected, actual.length);
    }

    @Test
    void shouldRemoveById() {
        repository.save(firstPhone);
        repository.save(secondPhone);
        repository.save(thirdPhone);
        Product[] expected = new Product[]{secondPhone, thirdPhone};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}


