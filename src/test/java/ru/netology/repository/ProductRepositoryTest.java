package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Smartphone firstPhone = new Smartphone(1, "Realme", 15_000, "Xiaomi");
    private Smartphone secondPhone = new Smartphone(2, "Apple", 50_000, "Apple");
    private Smartphone thirdPhone = new Smartphone(3, "BQ", 8_000, "Mundo Reader");


    @BeforeEach
    void setUp() {
        repository.save(firstPhone);
        repository.save(secondPhone);
        repository.save(thirdPhone);
    }

    @Test
    void shouldSuccessfullyDeleteAnExistingItem() {
        repository.removeById(1);
        Product[] expected = new Product[]{secondPhone, thirdPhone};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGenerateNotFoundExceptionWhenTryingRoDeleteANonExistentElement() {

        repository.removeById(20);
    }
}


