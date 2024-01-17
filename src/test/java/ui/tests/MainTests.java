package ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pages.MainPage;

import static io.qameta.allure.Allure.step;

@Owner("Nikita Postnikov")
@Feature("UI тесты arena.tarkov.com")
@Story("Главная страница arena.tarkov.com")

public class MainTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка отображения кнопок 'Войти' и 'Регистрация' на главной странице")
    @Severity(SeverityLevel.BLOCKER)
    void loginTest() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Нажимаем кнопку мой аккаунт", () -> {
            mainPage.openMyAccount();
        });
        step("Проверяем наличие кнопкок 'Войти' и 'Регистрация'", () -> {
            mainPage.checkLoginAndRegistration();
        });
    }

    @Test
    @DisplayName("Проверка наличия блока c социальными сетями в подвале страницы")
    @Severity(SeverityLevel.BLOCKER)
    void linksTest() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Проверяем, что на главной странице есть блок с социальными сетями", () -> {
            mainPage.checkSocialNetworkButton();
        });
    }

    @Test
    @DisplayName("Проверка отображения заголовков")
    @Severity(SeverityLevel.BLOCKER)
    void titleTest() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Проверяем, что на главной странице все заголовки отображаются корректно", () -> {
            mainPage.checkTitle();
        });
    }
}