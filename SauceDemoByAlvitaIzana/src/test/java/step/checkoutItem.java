package step;

import config.env;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object.cart;
import object.scroll;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class checkoutItem extends env {
    cart elementCart = new cart();
    scroll elementScrollDown = new scroll();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @And ("add some item")
    public void add_some_item() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(elementCart.getAddShirt()));
        driver.findElement(elementCart.getAddShirt()).click();
        Thread.sleep(3000);
        driver.findElement(elementCart.getRemoveShirt()).isDisplayed();
        System.out.println("Item berhasil ditambahkan!");
    }

    @And ("user verify the item")
    public void user_verify_item() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(elementCart.getCartContainer()));
        driver.findElement(elementCart.getCartContainer()).click();
        Thread.sleep(3000);
        String header = driver.findElement(elementCart.getHeaderContainer()).getText();
        Assert.assertTrue(header.contains("Your Cart"));
    }

    @And ("user check item in cart")
    public void user_check_item_in_cart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementCart.getVerifyCart()));
        String backpack = driver.findElement(elementCart.getVerifyCart()).getText();
        Assert.assertTrue(backpack.contains("Sauce Labs Backpack"));
        Thread.sleep(3000);
        Assert.assertTrue(backpack.contains("Sauce Labs Bolt T-Shirt"));
        System.out.println("Item berhasil masuk ke keranjang!");
    }

    @And ("user click Checkout")
    public void user_click_Checkout() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(elementCart.getBtnCheckout()));
        driver.findElement(elementCart.getBtnCheckout()).click();
        Thread.sleep(3000);
    }

    @When ("user input name and postal code")
    public void user_input_name_and_postal_code(DataTable dataTable) throws InterruptedException {
        String header = driver.findElement(elementCart.getHeaderContainer()).getText();
        Assert.assertTrue(header.contains("Checkout: Your Information"));
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String nameFirst = row.get("firstName");
            String nameLast = row.get("lastName");
            String codePostal = row.get("postalCode");

            WebElement firstNameField = driver.findElement(elementCart.getFirstName());
            firstNameField.sendKeys(nameFirst);
            Thread.sleep(1000);
            WebElement lastNameField = driver.findElement(elementCart.getLastName());
            lastNameField.sendKeys(nameLast);
            Thread.sleep(1000);
            WebElement postalCodeField = driver.findElement(elementCart.getPostalCode());
            postalCodeField.sendKeys(codePostal);
            Thread.sleep(1000);
        }
        System.out.println("Berhasil menambahkan informasi!");
    }

    @And ("user click Continue")
    public void user_click_Continue() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(elementCart.getBtnContinue()));
        driver.findElement(elementCart.getBtnContinue()).click();
        Thread.sleep(3000);
    }

    @And ("Checkout Overview displayed")
    public void checkout_overview() throws InterruptedException {
        String header = driver.findElement(elementCart.getHeaderContainer()).getText();
        Assert.assertTrue(header.contains("Checkout: Overview"));
        Thread.sleep(2000);
    }

    @When ("user click Finish")
    public void user_click_Finish() throws InterruptedException {
        elementScrollDown.scrollDown(driver);
        Thread.sleep(2000);
    }

    @Then ("user success to checkout item")
    public void user_success_to_checkout() throws InterruptedException {
        String header = driver.findElement(elementCart.getCheckoutSuccess()).getText();
        Assert.assertTrue(header.contains("Thank you for your order!"));
        driver.findElement(elementCart.getBtnBackHome()).click();
        Thread.sleep(2000);
        System.out.println("Checkout Item Telah Berhasil!");
    }
}
