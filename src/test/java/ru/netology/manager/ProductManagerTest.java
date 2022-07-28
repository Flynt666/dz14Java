package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);
    private final Book Book1 = new Book(1, "100 кулинарных рецептов", 135, "Евгений Пашот");
    private final Book Book2 = new Book(2, "Незнайка на Луне", 455, "Николай Носов");
    private final Smartphone Smartphone1 = new Smartphone(3, "Mi A1", 10_990, "Xiaomi");
    private final Smartphone Smartphone2 = new Smartphone(4, "Iphone 13 Pro Max", 115_999, "Apple");

    @BeforeEach
    void setUp() {
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Smartphone1);
        manager.add(Smartphone2);

    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{Book1, Book2, Smartphone1, Smartphone2};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralByBookAuthor() {
        Product[] expected = new Product[]{Book2};
        Product[] actual = manager.searchBy("Николай Носов");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBookTitle() {
        Product[] expected = new Product[]{Book2};
        Product[] actual = manager.searchBy("Незнайка на Луне");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneManufacturer() {
        Product[] expected = new Product[]{Smartphone1};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{Smartphone2};
        Product[] actual = manager.searchBy("Iphone 13 Pro Max");
        assertArrayEquals(expected, actual);
    }
}