package object;

import config.env;
import org.openqa.selenium.By;

public class cart extends env {
    By removeBackpack = By.id("remove-sauce-labs-backpack");

    public By getRemoveBackpack() {
        return removeBackpack;
    }

    By addShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    public By getAddShirt() {
        return addShirt;
    }

    By removeShirt = By.id("remove-sauce-labs-bolt-t-shirt");

    public By getRemoveShirt() {
        return removeShirt;
    }

    By cartContainer = By.id("shopping_cart_container");

    public By getCartContainer() {
        return cartContainer;
    }

    By verifyCart = By.id("cart_contents_container");

    public By getVerifyCart() {
        return verifyCart;
    }

    By btnCheckout = By.id("checkout");

    public By getBtnCheckout() {
        return btnCheckout;
    }

    By headerContainer = By.id("header_container");

    public By getHeaderContainer() {
        return headerContainer;
    }

    By firstName = By.id("first-name");

    public By getFirstName() {
        return firstName;
    }

    By lastName = By.id("last-name");

    public By getLastName() {
        return lastName;
    }

    By postalCode = By.id("postal-code");

    public By getPostalCode() {
        return postalCode;
    }

    By btnContinue = By.id("continue");

    public By getBtnContinue() {
        return btnContinue;
    }

    By btnFinish = By.id("finish");

    public By getBtnFinish() {
        return btnFinish;
    }

    By checkoutSuccess = By.id("checkout_complete_container");

    public By getCheckoutSuccess() {
        return checkoutSuccess;
    }

    By btnBackHome = By.id("back-to-products");

    public By getBtnBackHome() {
        return btnBackHome;
    }
}
