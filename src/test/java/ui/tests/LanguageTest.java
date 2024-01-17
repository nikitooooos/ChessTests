package ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ui.domain.Language;
import ui.pages.LanguagePage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Owner("Nikita Postnikov")
@Feature("UI тесты arena.tarkov.com")
@Story("Главная страница arena.tarkov.com")

public class LanguageTest extends TestBase {
    static Stream<Arguments> tarkovArenaButtonsTest() {
        return Stream.of(
                Arguments.of(Language.RU, List.of("Новости", "Поддержка", "Мерч", "Киберспорт", "Рейтинг")),
                Arguments.of(Language.EN, List.of("News", "Support", "Merch", "Esports", "Rating")),
                Arguments.of(Language.DE, List.of("News", "Support", "Merch", "Esports", "Ratings")),
                Arguments.of(Language.CN, List.of("新闻", "支持", "周边", "电子竞技", "排位")),
                Arguments.of(Language.IT, List.of("Novità", "Supporto", "Merce", "Esports", "Valutazione")),
                Arguments.of(Language.PL, List.of("Aktualności", "Wsparcie", "Sklep", "Esport", "Ocena")),
                Arguments.of(Language.TR, List.of("Haberler", "Destek", "Merch", "Esporlar", "Değerlendirme")),
                Arguments.of(Language.CZ, List.of("Novinky", "Podpora", "Merch", "Esport", "Hodnocení")),
                Arguments.of(Language.ES, List.of("Noticias", "Soporte", "Merch", "Esports", "Clasificación"))
        );
    }

    LanguagePage languagePage = new LanguagePage();

    @Severity(SeverityLevel.BLOCKER)
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