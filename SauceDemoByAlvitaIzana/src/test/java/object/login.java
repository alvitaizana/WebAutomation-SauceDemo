package object;

import config.env;
import org.openqa.selenium.By;

public class login extends env {
    By fieldUsername = By.id("user-name");

    public By getFieldUsername() {
        return fieldUsername;
    }

    By fieldPassword = By.id("password");

    public By getFieldPassword() {
        return fieldPassword;
    }

    By buttonLogin = By.id("login-button");

    public By getButtonLogin() {
        return buttonLogin;
    }

    By errorMessage = By.xpath("//*[@data-test='error']");

    public By getErrorMessage() {
        return errorMessage;
    }

    By addCartBackpack = By.id("add-to-cart-sauce-labs-backpack");

    public By getAddCartBackpack() {
        return addCartBackpack;
    }
}
