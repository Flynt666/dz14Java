package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    int nonexistentId = 4;
    private ProductRepository repository = new ProductRepository();
    private final Book Book1 = new Book(1, "100 кулинарных рецептов", 135, "Евгений Пашот");
    private final Book Book2 = new Book(2, "Незнайка на Луне", 455, "Николай Носов");

 
    @Test
    public void shouldRemoveById() {
        repository.save(Book1);
        repository.save(Book2);
        repository.removeById(2);
        Product[] expected = new Product[]{Book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveNonexistentId() {
        repository.save(Book1);
        repository.save(Book2);
        repository.removeById(nonexistentId);
        Product[] expected = new Product[]{Book1, Book2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
