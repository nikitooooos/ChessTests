package ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ui.pages.AddToCartPage;

import static io.qameta.allure.Allure.step;

@Owner("Nikita Postnikov")
@Feature("UI тесты arena.tarkov.com")
@Story("Добавление товара в корзину")

public class AddProductToCartTests extends TestBase {
    AddToCartPage addToCartPage = new AddToCartPage();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка добавления товара в корзину")
    void testAddToCart() {
        step("Открываем страницу товара", () -> {
            addToCartPage.openPage();
        });
        step("Выбираем доступный размер", () -> {
            addToCartPage.choseSizeProduct();
        });
        step("Добавляем товар в корзину", () -> {
            addToCartPage.addProductToCart();
        });
        step("Проверяем добавление товара в корзину", () -> {
            addToCartPage.checkCart();
        });
    }
}