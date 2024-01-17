package ui.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pages.CartPage;

import java.util.Locale;

import static io.qameta.allure.Allure.step;

@Owner("Nikita Postnikov")
@Feature("UI тесты arena.tarkov.com")
@Story("Добавление товара в корзину")

public class CartTests extends TestBase {
    public static final String country = "Россия";
    Faker faker = new Faker(new Locale("ru"));
    CartPage cartPage = new CartPage();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка добавления товара в корзину")
    void addProductToCardTest() {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userNumber = 89 + faker.phoneNumber().subscriberNumber(8);
        step("Открываем страницу товара", () -> {
            cartPage.openPage();
        });
        step("Выбираем доступный размер", () -> {
            cartPage.choseSizeProduct();
        });
        step("Добавляем товар в корзину", () -> {
            cartPage.addProductToCart();
        });
        step("Переходим в корзину", () -> {
            cartPage.checkCart();
        });
        step("Вводим персональные данные", () -> {
            cartPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserNumber(userNumber)
                    .setEmail(userEmail);
        });
        step("Выбираем страну отправки", () -> {
            cartPage.setCountry(country);
        });
        step("Выбираем вид доставки", () -> {
            cartPage.setDelivery();

        });
        step("Выбираем способ оплаты", () -> {
            cartPage.setPayment();
        });
        step("Проверяем отображение кнопки заказа", () -> {
            cartPage.order();
        });
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка удаления товара из корзины")
    void removeProductFromCartTest() {
        step("Открываем страницу товара", () -> {
            cartPage.openPage();
        });
        step("Выбираем доступный размер", () -> {
            cartPage.choseSizeProduct();
        });
        step("Добавляем товар в корзину", () -> {
            cartPage.addProductToCart();
        });
        step("Переходим в корзину", () -> {
            cartPage.checkCart();
        });
        step("Удаляем товар из корзины", () -> {
            cartPage.delete();
        });
        step("Проверяем, что корзина пуста", () -> {
            cartPage.deleteResult();
        });
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка добавления товара, которого нет в наличии")
    void outOfStockCartTest() {
        step("Открываем страницу товара", () -> {
            cartPage.openPage();
        });
        step("Выбираем размер, которого нет в наличии", () -> {
            cartPage.outOfStockSizeProduct();
        });
        step("Проверяем отображение кнопки заказа", () -> {
            cartPage.outOfStock();
        });
    }
}