package ru.netology.javaqamvn.catalog.repository;
import ru.netology.javaqamvn.catalog.domain.Book;
import ru.netology.javaqamvn.catalog.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqamvn.catalog.domain.Smartphone;
import ru.netology.javaqamvn.catalog.exceptions.NotFoundException;

public class ProductRepositoryTest {

    Product product1 = new Book(157, "Война и Мир", "Л.Н.Толстой", 5_999);
    Product product2 = new Book(587, "Остров Сахалин","А.П.Чехов", 900);
    Product product3 = new Smartphone(689, "IPhone X","Apple", 47_999);

    @Test
    public void testSave() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeProductId(product2.getID());

        Product[] expected = {product1, product3};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProductById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(157);

        Product[] actual = repo.getProduct();
        Product[] expected = new Product[]{product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDeleteProductById() {
        ProductRepository repo = new ProductRepository();
        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(0));
    }
}
