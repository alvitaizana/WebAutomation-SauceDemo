package step;

import config.env;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object.cart;
import object.login;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class loginSuccess extends env {
    login elementLogin = new login();
    cart elementCart = new cart();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Given ("access to page login")
    public void accessPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLogin.getFieldPassword()));
    }

    @And ("user input password")
    public void user_input_password(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Password = row.get("password");
            WebElement passwordField = driver.findElement(elementLogin.getFieldPassword());
            passwordField.sendKeys(Password);
        }
    }

    //LOGIN TO USERNAME standard_user
    @When ("user input username1")
    public void user_input_username1(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Username1 = row.get("username1");

            WebElement usernameField = driver.findElement(elementLogin.getFieldUsername());
            usernameField.sendKeys(Username1);
        }
    }
    @Then ("user success login to first account")
    public void successLogin() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyCart = driver.findElement(elementLogin.getAddCartBackpack());
        if (verifyCart.isDisplayed()) {
            driver.findElement(elementLogin.getAddCartBackpack()).click();
            Thread.sleep(3000);
            driver.findElement(elementCart.getRemoveBackpack()).isDisplayed();
            System.out.println("Successfully Logged in!");
        }
        else {
            System.out.println("Failed to Logged in!");
        }
    }


    // LOGIN TO USERNAME problem_user
    @When ("user input username3")
    public void user_input_username3(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Username3 = row.get("username3");

            WebElement usernameField = driver.findElement(elementLogin.getFieldUsername());
            usernameField.sendKeys(Username3);
        }
    }
    @Then ("user success login to third account")
    public void user_success_login_to_third_account() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyCart = driver.findElement(elementLogin.getAddCartBackpack());
        if (verifyCart.isDisplayed()) {
            driver.findElement(elementLogin.getAddCartBackpack()).click();
            Thread.sleep(5000);
            System.out.println("Successfully Logged in!");
        }
        else {
            System.out.println("Failed to Logged in!");
        }
    }


    // LOGIN TO USERNAME performance_glitch_user
    @When ("user input username4")
    public void user_input_username4(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Username4 = row.get("username4");

            WebElement usernameField = driver.findElement(elementLogin.getFieldUsername());
            usernameField.sendKeys(Username4);
        }
    }
    @Then ("user success login to fourth account")
    public void user_success_login_to_fourth_account() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyCart = driver.findElement(elementLogin.getAddCartBackpack());
        if (verifyCart.isDisplayed()) {
            driver.findElement(elementLogin.getAddCartBackpack()).click();
            Thread.sleep(5000);
            System.out.println("Successfully Logged in!");
        }
        else {
            System.out.println("Failed to Logged in!");
        }
    }
}
