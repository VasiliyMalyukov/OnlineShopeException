package ru.netology.javaqamvn.catalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqamvn.catalog.domain.Book;
import ru.netology.javaqamvn.catalog.domain.Product;
import ru.netology.javaqamvn.catalog.domain.Smartphone;
import ru.netology.javaqamvn.catalog.manager.ProductManager;
import ru.netology.javaqamvn.catalog.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Book(157, "Война и Мир", "Л.Н.Толстой", 5_999);
    Product product2 = new Book(587, "Остров Сахалин","А.П.Чехов", 900);
    Product product3 = new Smartphone(689, "IPhone X","Apple", 47_999);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }

    @Test
    public void testAdd() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Ищем один продукт:
    @Test
    public void testSearchByOneProduct() {

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("IPhone X");

        Assertions.assertArrayEquals(expected, actual);
    }

    //Ищем 2 продукта:
    @Test
    public void testSearchBySomeProducts() {

        Product[] expected = {product1, product2};
        Product[] actual = manager.searchBy("а");

        Assertions.assertArrayEquals(expected, actual);
    }

    //Ищем 0 продуктов:
    @Test
    public void testSearchByZeroProduct() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("u");

        Assertions.assertArrayEquals(expected, actual);
    }
}
