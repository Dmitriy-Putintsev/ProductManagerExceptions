package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(6, "За пределами мозга", 1_000, "Станислав Гроф");

    @Test
    void shouldGetAuthor() {
        book.setAuthor("Станислав Гроф");
        String expected = "Станислав Гроф";
        String actual = book.getAuthor();
        assertEquals(expected, actual);
    }

}