package ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ui.pages.MerchPage;

import static io.qameta.allure.Allure.step;

@Owner("Nikita Postnikov")
@Feature("UI тесты arena.tarkov.com")
@Story("Страница с мерчем")

public class MerchTest extends TestBase {

    MerchPage merchPage = new MerchPage();
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия категорий товаров на странице с мерчем")
    void checkMerchPage(){
        step("Открываем главную страницу", () -> {
            merchPage.openPage();
        });
        step("Переходим на страницу с мерчем, нажатием на кнопку 'Мерч' на верхней панели", () -> {
            merchPage.openMerchPage();
        });
        step("Проверяем, что категории товаров на странице отображаются", () -> {
            merchPage.checkCategory();
        });
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия товаров на странице с мерчем")
    void checkProducts(){
    step("Открываем главную страницу", () -> {
        merchPage.openPage();
    });
    step("Переходим на страницу с мерчем, нажатием на кнопку 'Мерч' на верхней панели", () -> {
        merchPage.openMerchPage();
    });
    step("Проверяем, что товар на странице отображается", () -> {
        merchPage.checkProduct();
    });
    }

}