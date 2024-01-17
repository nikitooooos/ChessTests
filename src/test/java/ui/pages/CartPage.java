package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {
    private static final String URL_PRODUCT = "https://tarkovmerchstore.com/ru/product/arena-t-shirt";
    SelenideElement
            chooseColorBlack = $("#optionsContainer .product-form [title=\"Черный\"]"),
            chooseColorGrey = $("#optionsContainer .product-form [title=\"Серый\"]"),
            chooseSize = $("#optionsContainer .product-form .option [title=\"44-46\"]"),
            addCartButton = $(byText("В корзину")),
            сartButton = $(".cart-btn-not-available"),
            toCartButton = $(".cart-container .to-cart-btn"),
            firstNameInput = $("#formulate--ru-checkout-1"),
            lastNameInput = $("#formulate--ru-checkout-2"),
            userNumberInput = $("#formulate--ru-checkout-3"),
            userEmailInput = $("#formulate--ru-checkout-4"),
            countrySearch = $(".vs__search"),
            pickupButton = $(byText("Самовывоз")),
            paymentButton = $(byText("Visa, Mastercard, Мир")),
            deleteButton = $(".cart-item-delete"),
            emptyCartPage = $(".empty-cart-header"),
            orderButton = $(".btn-checkout");

    public CartPage openPage() {
        open(URL_PRODUCT);
        return this;
    }

    public CartPage choseSizeProduct() {
        chooseColorBlack.shouldBe(visible).click();
        chooseSize.shouldBe(visible).click();
        return this;
    }

    public CartPage addProductToCart() {
        addCartButton.shouldBe(visible).doubleClick();
        return this;
    }

    public CartPage checkCart() {
        toCartButton.shouldBe(visible).shouldHave(text("В корзине")).click();
        return this;
    }

    public CartPage setFirstName(String value) {
        firstNameInput.shouldBe(visible).setValue(value);
        return this;
    }

    public CartPage setLastName(String value) {
        lastNameInput.shouldBe(visible).setValue(value);
        return this;
    }

    public CartPage setUserNumber(String value) {
        userNumberInput.shouldBe(visible).setValue(value);
        return this;
    }

    public CartPage setEmail(String value) {
        userEmailInput.shouldBe(visible).setValue(value);
        return this;
    }

    public CartPage setCountry(String country) {
        countrySearch.shouldBe(visible).setValue(country).pressEnter();
        return this;
    }

    public CartPage setDelivery() throws InterruptedException {
        pickupButton.shouldBe(visible).click();
        Thread.sleep(3000);
        return this;
    }

    public CartPage setPayment() {
        paymentButton.shouldBe(visible).click();
        return this;
    }

    public CartPage order() {
        orderButton.shouldHave(text("Заказать"));
        return this;
    }

    public CartPage delete() {
        deleteButton.click();
        return this;
    }

    public CartPage deleteResult() {
        emptyCartPage.shouldHave(text("В корзине пока пусто"));
        return this;
    }

    public CartPage outOfStockSizeProduct() {
        chooseColorGrey.shouldBe(visible).click();
        return this;
    }

    public CartPage outOfStock() {
        сartButton.shouldHave(text("Нет в наличии")).shouldBe(disabled);
        return this;
    }
}
