package darazAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class DarazAutomationTest {
    public static void main(String[] args) throws InterruptedException {
        //Set browser properties
        System.setProperty("webdriver.chrome.driver", "C:/Browserdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //call the url
        driver.get("https://daraz.com.np");

        //Find login element
        driver.findElement(By.xpath("//a[text()='login']")).click();
        //Find email and password field
        driver.findElement(By.xpath("//input[@placeholder='Please enter your Phone Number or Email']")).sendKeys("9841317477");
        driver.findElement(By.xpath("//input[@placeholder='Please enter your password']")).sendKeys("tralala123");
        //find login button element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);
        // Mouse hover
        Actions actions = new Actions(driver);
        //Find men fashion element
        WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"Level_1_Category_No9\"]" ));
        actions.moveToElement(ele1).perform();
        //Find shoes element
        WebElement ele2 = driver.findElement(By.xpath("//span[text()='Shoes']"));
        actions.moveToElement(ele2).perform();
        //Find boots element
        WebElement ele3 = driver.findElement(By.xpath("//span[text()='Boots']"));
        actions.moveToElement(ele3).click().build().perform();

        //Find element of sort by div
        driver.findElement(By.xpath("//div[@class='c3trXJ']")).click();
        driver.findElement(By.xpath("//div[text()='Price high to low']")).click();

        Thread.sleep(1000);
        //Find last element of the list
        WebElement lastItem= driver.findElement(By.xpath("//div[@class='c2prKC'][last()]"));
        ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastItem);
        Thread.sleep(1000);
        lastItem.click();

        //Get name of the product
        String oldName = driver.findElement(By.cssSelector(".pdp-mod-product-badge-title")).getText();
        //Clicked add to cart button
        driver.findElement(By.xpath("//div[@class='pdp-cart-concern']//button[2]")).click();

        //Clicked Goto Cart button
        driver.findElement(By.xpath("//button[text()='GO TO CART']")).click();

        //Validate product in the cart with selected product
        Assert.assertEquals(oldName, "Solid Short Dingo Boot For Men (6810-1A)");

        //Close browser
        driver.close();
    }
}
