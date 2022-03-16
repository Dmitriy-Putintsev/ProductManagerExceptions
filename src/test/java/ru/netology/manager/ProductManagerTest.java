package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Smartphone firstPhone = new Smartphone(1, "Realme", 15_000, "Xiaomi");
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
    void shouldGetAll() {
        Product[] expected = new Product[]{firstPhone, secondPhone, thirdPhone, firstBook, secondBook, thirdBook};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNameBook() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Метод Вайкоффа");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNameSmartPhone() {
        Product[] expected = new Product[]{firstPhone};
        Product[] actual = manager.searchBy("Realme");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAuthorBook() {
        Product[] expected = new Product[]{thirdBook};
        Product[] actual = manager.searchBy("Станислав Гроф");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindManufacturePone() {
        Product[] expected = new Product[]{thirdPhone};
        Product[] actual = manager.searchBy("Mundo Reader");
        assertArrayEquals(expected, actual);
    }
}


