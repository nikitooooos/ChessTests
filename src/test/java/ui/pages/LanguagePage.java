package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ui.domain.Language;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class LanguagePage {
    SelenideElement
            languageMenu = $(".navBlock .selector");
    ElementsCollection
            languageItem = $$(".selector .outer .submenu .inner li" ),
            buttons = $$("ul .item");
    private static final String url = "https://arena.tarkov.com";

    public void openPage() {
        open(url);
    }
    public void openLanguageMenu() {
        languageMenu.click();
    }
    public void findLanguage(Language language) {
        languageItem.find(text(language.name())).click();
    }
    public void checkExpectedButtons(List<String> expectedButtons) {
        buttons.filter(visible).shouldHave(texts(expectedButtons));
    }
}