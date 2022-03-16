package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Smartphone firstPhone = new Smartphone(1, "Метод Вайкоффа", 15_000, "Джек К.Хатсон");
    private Smartphone secondPhone = new Smartphone(2, "Apple", 50_000, "Apple");
    private Smartphone thirdPhone = new Smartphone(3, "BQ", 8_000, "Mundo Reader");
    private Book firstBook = new Book(4, "Технический Анализ", 743, "Джек Швагер");
    private Book secondBook = new Book(5, "Метод Вайкоффа", 945, "Джек К.Хатсон");
    private Book thirdBook = new Book(6, "За пределами мозга", 1_000, "Станислав Гроф");

    @BeforeEach
    void setUp() {
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
    }

    @Test
    void shouldDisplaySeveralSuitableProducts() {
        Product[] expected = new Product[]{firstPhone, secondBook};
        Product[] actual = manager.searchBy("Метод Вайкоффа");
        assertArrayEquals(expected, actual);
    }

}
