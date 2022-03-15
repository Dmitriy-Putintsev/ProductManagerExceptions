package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(1, "Realme", 15_000, "Xiaomi");

    @Test
    void shouldGetManufacture() {
        smartphone.setManufacturer("Xiaomi");
        String expected = "Xiaomi";
        String actual = smartphone.getManufacturer();
        assertEquals(expected, actual);
    }
}