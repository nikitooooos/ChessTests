package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MerchPage {
    SelenideElement searchButton = $(".setting-link .search-icon"),
            searchTitle = $(".search-amount"),
            itemsList = $(".grid-item-container"),
    searchContainer = $("#search");
    ElementsCollection
            merchItem = $$("ul .item");

    public static final String urlMerch = "https://tarkovmerchstore.com/category/arena";
    public static final String searchValue = "Cup";

    public void openPage() {
        open("");
    }
    public void openMerchPage() {
        merchItem.findBy(text("Мерч")).click();
    }
    public void checkPageIsOpen(String urlMerch) {
        switchTo().window(1);
        webdriver().shouldHave(url(urlMerch));
    }
    public void openSearch() {
        searchButton.shouldBe(visible).click();
    }
    public void searchProduct(String searchValue) {
        searchContainer.setValue(searchValue).pressEnter();
    }
    public void checkResultProduct() {
        searchTitle.shouldHave(text("8 product(s) found"));
    }
    public void checkProduct() {
        itemsList.shouldHave(text("\"ARENA\" T-shirt"));
    }

}
