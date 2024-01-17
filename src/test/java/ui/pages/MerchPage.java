package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MerchPage {
    SelenideElement
            itemsList = $(".grid-item-container");
    ElementsCollection
            categoryItem = $$("ul .game-menu-item"),
            merchItem = $$("ul .item");

    public MerchPage openPage() {
        open("");
        return this;
    }

    public void openMerchPage() {
        merchItem.findBy(text("Мерч")).click();
        switchTo().window(1);
    }

    public void checkProduct() {
        itemsList.shouldHave(text("\"ARENA\" T-shirt"));
    }

    public void checkCategory() {
        categoryItem.shouldHave(texts("Patches", "In Game Stuff", "Clothes", "Souvenirs", "Books", "Arena"));
    }
}
