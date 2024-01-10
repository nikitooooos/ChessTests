package ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ui.pages.MerchPage;

import static io.qameta.allure.Allure.step;
import static ui.pages.MerchPage.searchValue;
import static ui.pages.MerchPage.urlMerch;

@Owner("Nikita Postnikov")
@Feature("UI тесты arena.tarkov.com")
@Story("Страница с мерчем")
@Tags({@Tag("ui")})

public class MerchTest extends TestBase {

    MerchPage merchPage = new MerchPage();
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка открытия страницы с мерчем")
    void checkMerchPage(){
    step("Открываем главную страницу", () -> {
        merchPage.openPage();
    });
    step("Переходим на страницу с мерчем, нажатием на кнопку 'Мерч' на верхней панели", () -> {
        merchPage.openMerchPage();
    });
    step("Проверяем, что открыли страницу с мерчем", () -> {
        merchPage.checkPageIsOpen(urlMerch);
    });
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Поиск товара")
    void searchMerch(){
    step("Открываем главную страницу", () -> {
        merchPage.openPage();
    });
    step("Переходим на страницу с мерчем, нажатием на кнопку 'Мерч' на верхней панели", () -> {
        merchPage.openMerchPage();
    });
    step("Проверяем, что открыли страницу с мерчем", () -> {
        merchPage.checkPageIsOpen(urlMerch);
    });
    step("Открываем поисковый контейнер", () -> {
        merchPage.openSearch();
    });
    step("Вводим значение 'Cup' в поле поиска", () -> {
        merchPage.searchProduct(searchValue);
    });
    step("Проверяем результат поиска", () -> {
        merchPage.checkResultProduct();
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
    step("Проверяем, что открыли страницу с мерчем", () -> {
        merchPage.checkPageIsOpen(urlMerch);
    });
    step("Проверяем, что товар на странице отображается", () -> {
        merchPage.checkProduct();
    });
    }
}