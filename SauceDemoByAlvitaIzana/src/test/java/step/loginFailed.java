package step;

import config.env;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object.login;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class loginFailed extends env {
    login elementLogin = new login();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // LOGIN TO USERNAME locked_out_user
    @When("user input username2")
    public void user_input_username2(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Username2 = row.get("username2");

            WebElement usernameField = driver.findElement(elementLogin.getFieldUsername());
            usernameField.sendKeys(Username2);
        }
    }
    @Then("user failed to login")
    public void user_failed_to_login() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyAccount = driver.findElement(elementLogin.getErrorMessage());
        if (!(verifyAccount.isDisplayed())) {
            System.out.println("Successfully Logged in!");
        }
        else {
            String actual_msg = driver.findElement(elementLogin.getErrorMessage()).getText();
            String expect="Epic sadface: Sorry, this user has been locked out.";
            Assert.assertEquals(actual_msg, expect);
            System.out.println("Failed to Logged in! User has been Locked Out!");
        }
    }

    // Failed login with unvalid username
    @When("user input username5")
    public void user_input_username5(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Username5 = row.get("username5");

            WebElement usernameField = driver.findElement(elementLogin.getFieldUsername());
            usernameField.sendKeys(Username5);
        }
    }
    @Then("user failed login")
    public void failedLogin() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyAccount = driver.findElement(elementLogin.getErrorMessage());
        if (!(verifyAccount.isDisplayed())) {
            System.out.println("Successfully Logged in!");
        }
        else {
            String actual_msg = driver.findElement(elementLogin.getErrorMessage()).getText();
            String expect="Epic sadface: Username and password do not match any user in this service";
            Assert.assertEquals(actual_msg, expect);
            System.out.println("Failed to Logged in! Username is incorrect!");
        }
    }


    // Failed login with empty username
    @When("username empty")
    public void username_empty() {

    }
    @Then("user failed login with empty username")
    public void emptyUsername() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyAccount = driver.findElement(elementLogin.getErrorMessage());
        if (!(verifyAccount.isDisplayed())) {
            System.out.println("Successfully Logged in!");
        }
        else {
            String actual_msg = driver.findElement(elementLogin.getErrorMessage()).getText();
            String expect="Epic sadface: Username is required";
            Assert.assertEquals(actual_msg, expect);
            System.out.println("Failed to Logged in! Username is Empty!");
        }
    }


    // Login with empty password
    @When("user input username7")
    public void inputUsername(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Username7 = row.get("username7");

            WebElement usernameField = driver.findElement(elementLogin.getFieldUsername());
            usernameField.sendKeys(Username7);
        }
    }

    @And("password is empty")
    public void emptyPassword() {

    }

    @Then("user failed to login with emptyPassword")
    public void failedLoginEmptyPassword() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyAccount = driver.findElement(elementLogin.getErrorMessage());
        if (!(verifyAccount.isDisplayed())) {
            System.out.println("Successfully Logged in!");
        }
        else {
            String actual_msg = driver.findElement(elementLogin.getErrorMessage()).getText();
            String expect="Epic sadface: Password is required";
            Assert.assertEquals(actual_msg, expect);
            System.out.println("Failed to Logged in! Password is empty!");
        }
    }


    // Login with empty username and password
    @When("username is empty")
    public void usernameEmpty() {

    }

    @And("password empty")
    public void passwordEmpty() {

    }

    @Then("user failed login with emptyField")
    public void emptyField() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyAccount = driver.findElement(elementLogin.getErrorMessage());
        if (!(verifyAccount.isDisplayed())) {
            System.out.println("Successfully Logged in!");
        }
        else {
            String actual_msg = driver.findElement(elementLogin.getErrorMessage()).getText();
            String expect ="Epic sadface: Username is required";
            Assert.assertEquals(actual_msg, expect);
            System.out.println("Failed to Logged in! Username and Password is Empty!");
        }
    }


    // Failed login with wrong password
    @When("user input valid username")
    public void inputValidUsername(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3000);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Username = row.get("username");

            WebElement usernameField = driver.findElement(elementLogin.getFieldUsername());
            usernameField.sendKeys(Username);
        }
    }

    @And("input wrong password")
    public void wrongPassword(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String Password = row.get("password");

            WebElement passwordField = driver.findElement(elementLogin.getFieldPassword());
            passwordField.sendKeys(Password);
        }
    }

    @Then("login failed")
    public void loginFailed() throws InterruptedException {
        driver.findElement(elementLogin.getButtonLogin()).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        WebElement verifyAccount = driver.findElement(elementLogin.getErrorMessage());
        if (!(verifyAccount.isDisplayed())) {
            System.out.println("Successfully Logged in!");
        }
        else {
            String actual_msg = driver.findElement(elementLogin.getErrorMessage()).getText();
            String expect="Epic sadface: Username and password do not match any user in this service";
            Assert.assertEquals(actual_msg, expect);
            System.out.println("Failed to Logged in! Password incorrect!");
        }
    }
}
