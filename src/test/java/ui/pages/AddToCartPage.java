package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AddToCartPage {

    private static final String URL_PRODUCT = "/product/arena-t-shirt";

    SelenideElement
            chooseColor = $x("//div[text()=\"Выберите размер\"]"),
            chooseSize = $(".recaptcha .ui-product-page-sizes-chooser-item_enabled", 0),
            addCartButton = $(".cart-add"),
            popupText = $(".d-modal__frame .d-modal__header"),
            toCartButton = $(".to-cart-btn"),
            confirmForm = $(".form-flex");

    public AddToCartPage openPage() {
        open(URL_PRODUCT);
        return this;
    }

    public AddToCartPage choseSizeProduct() {
        chooseColor.click();
        chooseSize.click();
        return this;
    }

    public AddToCartPage addProductToCart() {
        addCartButton.shouldBe(visible).click();
        return this;
    }

    public AddToCartPage checkCart() {
        toCartButton.shouldBe(visible).click();
        return this;
    }
    public AddToCartPage checkPopup() {
        popupText.shouldHave(text("Confirm Order"));
        return this;
    }
}
