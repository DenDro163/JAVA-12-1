package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final Repository repo = new Repository();
    private final ProductManager manager = new ProductManager(repo);
    private final Product book1 = new Book(1, "Война и мир", 900, "Лев Толстой");
    private final Product book2 = new Book(2, "Ночной дозор", 600, "Сергей Лукьяненко");
    private final Product book3 = new Book(3, "Ночной дозор", 690, "Сара Уотерс");
    private final Product smartphone1 = new Smartphone(4, "Redmi 9", 13450, "Xiaomi");
    private final Product smartphone2 = new Smartphone(5, "IPhone 11", 55900, "Apple");


    @Test
    public void shouldTestAddBook() {
        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestAddSmartphone() {
        manager.add(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldTestAddBookAndSmartphone() {
        manager.add(book1);
        manager.add(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldTestOneMatchTest() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        String name = "Война и мир";

        Product[] expected = {book1};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldTestNoMatchTest() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        String name = "Не книга";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldTestNameMatchTest() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        String name = "Ночной дозор";

        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

}