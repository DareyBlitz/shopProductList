package ru.netology.javaqa.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void removeTest() {
        ShopRepository repo = new ShopRepository();

        Product item1 = new Product(1, "наушники", 740);
        Product item2 = new Product(2, "планшет", 13_000);
        Product item3 = new Product(3, "стилус", 2500);
        Product item4 = new Product(4, "чехол", 500);
        Product item5 = new Product(5, "зарядка", 360);

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);

        repo.remove(5);


        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11,"телефон", 30_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(44)
        );
    }


    @Test
    public void testSaveNothing() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11,"телефон", 30_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);



        Product[] expected = {};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSave() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11,"телефон", 30_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void testRemoveWhenProductAlreadyExist() {
//        ShopRepository repo = new ShopRepository();
//        Product product1 = new Product(11,"телефон", 30_000);
//        Product product2 = new Product(22, "книга", 300);
//        Product product3 = new Product(300, "машина", 3_000_000);
//
//        repo.add(product1);
//        repo.add(product2);
//        repo.add(product3);
//
//        Assertions.assertThrows(AlreadyExistsException.class,
//                () -> repo.save(22)
//        );
//    }

//    @Test
//    public void testSaveOne() {
//        ShopRepository repo = new ShopRepository();
//        Product product1 = new Product(11,"телефон", 30_000);
//        Product product2 = new Product(22, "книга", 300);
//        Product product3 = new Product(300, "машина", 3_000_000);
//
//
//        repo.save(11);
//        repo.save(22);
//        repo.save(300);
//
//        Product[] expected = {product1, product2, product3};
//        Product[] actual = repo.findAll();
//        Assertions.assertArrayEquals(expected, actual);
//    }

}