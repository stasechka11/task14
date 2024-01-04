package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    Product product1 = new Product(1, "Батон", 30);
    Product product2 = new Product(2, "Печенье", 50);
    Product product3 = new Product(3, "Шоколад", 70);

    @Test
    public void shouldRemoveById() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        shopRepository.remove(2);

        Product[] expected = {product1, product3};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenRemoveByIdNull() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(4);
        });
    }

    @Test
    public void shouldAddProduct() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenAddExistingId() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(product2);
        });
    }
}