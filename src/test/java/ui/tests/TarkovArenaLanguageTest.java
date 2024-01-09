package ui.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ui.domain.Language;
import ui.pages.LanguagePage;
import ui.pages.components.TarkovArenaButtons;

import java.util.List;

import static io.qameta.allure.Allure.step;

@Owner("Nikita Postnikov")
@Feature("UI тесты arena.tarkov.com")
@Story("Главная страница arena.tarkov.com")
@Tags({@Tag("ui")})


public class TarkovArenaLanguageTest implements TarkovArenaButtons {
    LanguagePage languagePage = new LanguagePage();
    @DisplayName("Проверка отображения кнопок верхней панели")
    @ParameterizedTest(name = "Проверка отображения кнопок верхней панели для языка {0}")
    @MethodSource("tarkovArenaButtonsTest")
    void tarkovArenaButtonsTest(Language language, List<String> expectedButtons) {
        step("Открываем главную страницу", () -> {
            languagePage.openPage();
        });
        step("Открываем меню языков", () -> {
            languagePage.openLanguageMenu();
        });
        step("Выбираем нужный язык", () -> {
            languagePage.findLanguage(language);
        });
        step("Проверяем отображение кнопок", () -> {
            languagePage.checkExpectedButtons(expectedButtons);
        });
    }
}