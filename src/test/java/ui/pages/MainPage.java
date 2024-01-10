package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement
            accountMenu = $(".user_login"),
            vkButton = $(".social .social_item [alt=\"VK\"]"),
            youtubeButton = $(".social .social_item [alt=\"Youtube\"]"),
            tikTokButton = $(".social .social_item [alt=\"TikTok\"]"),
            twitchButton = $(".social .social_item [alt=\"Twitch\"]");

    ElementsCollection userButtons = $$(".user-menu-btns .inner .name_button" ),
    title1 = $$(".welcome .lead"),
    title2 = $$(".bets .lead"),
    title3 = $$(".equipment .lead"),
    title4 = $$(".skills  .lead"),
    title5 = $$(".rank .lead"),
    title6 = $$(".arsenal .lead"),
    title7 = $$(".buy .lead");

    public void openPage() {
        open("");
    }
    public void openMyAccount() {
        accountMenu.click();
    }
    public void checkLoginAndRegistration() {
        userButtons.filter(visible).shouldHave(texts("Войти", "Регистрация"));
    }
    public void checkTitle() {
        title1.shouldHave(texts("ВЕЛКАМ ТУ АРЕНА, РЕБЯТА!"));
        title2.shouldHave(texts("Ставки сделаны"));
        title3.shouldHave(texts("Снаряжение готово"));
        title4.shouldHave(texts("Две игры, один персонаж"));
        title5.shouldHave(texts("Ранг решает"));
        title6.shouldHave(texts("Большой арсенал"));
        title7.shouldHave(texts("Escape from Tarkov: Arena"));
    }
    public MainPage checkSocialNetworkButton() {
        vkButton.should(appear);
        youtubeButton.should(appear);
        tikTokButton.should(appear);
        twitchButton.should(appear);
        return this;
    }
}

