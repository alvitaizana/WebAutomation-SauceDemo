package object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class scroll {
    public void scrollDown (WebDriver driver) throws InterruptedException {
        cart elementCart = new cart();
        // Define the text you want to find
        String targetText = "Finish";

        boolean textFound = false;

        while (!textFound) {
            // Simulate pressing the "DOWN" key
            driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);

            // Check if the page source contains the target text
            if (driver.getPageSource().contains(targetText)) {
                textFound = true;
                Thread.sleep(2000);
                driver.findElement(elementCart.getBtnFinish()).click();
            }
        }
    }
}
