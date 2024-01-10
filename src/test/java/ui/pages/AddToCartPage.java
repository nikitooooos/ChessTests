package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AddToCartPage {
    private static final String URL_PRODUCT = "https://tarkovmerchstore.com/product/arena-t-shirt";
    SelenideElement
            chooseColor = $("#optionsContainer .product-form [title=\"Black\"]");
    SelenideElement chooseSize = $("#optionsContainer .product-form .option [title=\"44-46\"]");
    SelenideElement addCartButton = $(byText("Add to cart"));
    SelenideElement toCartButton = $(".add-to-cart-block-desktop .cart-btn");
    public AddToCartPage openPage() {
        open(URL_PRODUCT);
        return this;
    }

    public AddToCartPage choseSizeProduct() {
        chooseColor.shouldBe(visible).click();
        chooseSize.shouldBe(visible).click();
        return this;
    }

    public AddToCartPage addProductToCart() {
        addCartButton.shouldBe(visible).doubleClick();
         return this;
    }

    public AddToCartPage checkCart() {
        toCartButton.shouldBe(visible).shouldHave(text("Add to cart"));
        return this;
    }
}
