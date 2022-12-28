package sysco.com.pom_Issue_Fix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CartPage {

    public SoftAssert softAssert = new SoftAssert();
    public static Boolean isMsgListEmpty;


    public void viewShoppingCart() {

        //check whether cart has any items in it
        LoginPage.syscoLabUIOgm.click(LoginPage.syscoLabUIOgm.findElement(By.xpath("//div[@class='minicart-wrapper']")));

        try {
            LoginPage.syscoLabUIOgm.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            isMsgListEmpty = LoginPage.syscoLabUIOgm.findElements(By.xpath("//span[contains(text(),'You have no items in your shopping cart.')]")).size() > 0;
            LoginPage.syscoLabUIOgm.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("No items message was not displayed");
        }

        if (isMsgListEmpty == true) {
            System.out.println("invalid");
            String noItemMessage = LoginPage.syscoLabUIOgm.findElement(By.xpath("//span[contains(text(),'You have no items in your shopping cart.')]")).getText();
            softAssert.assertEquals(noItemMessage, "You have no items in your shopping cart.");

            LoginPage.syscoLabUIOgm.setTimeOut(1000);
            String pageTitle = LoginPage.syscoLabUIOgm.getTitle();
            System.out.println(pageTitle);

            if (pageTitle.equalsIgnoreCase("My Account")) {
                softAssert.assertEquals(pageTitle, "My Account");
            } else {
                softAssert.assertEquals(pageTitle, "Customer Login");
            }
            softAssert.assertAll();
            LoginPage.syscoLabUIOgm.quit();
        } else {
            System.out.println("valid");
            try {
                WebElement viewCart = LoginPage.syscoLabUIOgm.getDriver().findElement(By.xpath("//*[@href='https://www.theathletesfoot.com.au/checkout/cart/']"));
                LoginPage.syscoLabUIOgm.scrollToElement(viewCart);
                JavascriptExecutor executor = (JavascriptExecutor) LoginPage.syscoLabUIOgm.getDriver();
                executor.executeScript("arguments[0].click();", viewCart);
            } catch (Exception e) {
                System.out.println("Element not found");
            }
            LoginPage.syscoLabUIOgm.setTimeOut(1000);
            String pageUrl = LoginPage.syscoLabUIOgm.getCurrentURL();
            System.out.println(pageUrl);

            softAssert.assertEquals(pageUrl, "https://www.theathletesfoot.com.au/checkout/cart/");
            softAssert.assertAll();
        }
    }

    public void manageShoppingCart() {
        LoginPage.syscoLabUIOgm.setTimeOut(1000);
        Boolean isShoppingCartTableDisplayed = LoginPage.syscoLabUIOgm.isDisplayed(By.id("shopping-cart-table"));
        System.out.println(isShoppingCartTableDisplayed);

        List<WebElement> items = LoginPage.syscoLabUIOgm.findElements(By.xpath("//tbody[@class='cart item']"));
        int itemCount = items.size();

        if (itemCount != 0) {
            for (WebElement productList : items) {
                WebElement removeButton = LoginPage.syscoLabUIOgm.findElement(By.xpath("//a[@class='action action-delete']"));
                LoginPage.syscoLabUIOgm.click(removeButton);
            }
        } else {
            Boolean isNoItemMessageDisplayed = LoginPage.syscoLabUIOgm.findElement(By.xpath("//span[contains(text(),'You have no items in your shopping cart.')]")).isDisplayed();
            softAssert.assertTrue(isNoItemMessageDisplayed, "Message was not displayed");
            softAssert.assertAll();
        }
    }

    public void addItemsToShoppingCart() {

        LoginPage.syscoLabUIOgm.findElement(By.xpath("//a[@href='https://www.theathletesfoot.com.au/']")).click();

        LoginPage.syscoLabUIOgm.setTimeOut(3000);
        LoginPage.syscoLabUIOgm.waitTillElementLoaded(By.xpath("//a[@href = 'https://www.theathletesfoot.com.au/shop/hubs/fitness/clothing']"));
        LoginPage.syscoLabUIOgm.scrollToElement(By.xpath("//a[@href = 'https://www.theathletesfoot.com.au/shop/hubs/fitness/clothing']"));
        WebElement fitnessClothing = LoginPage.syscoLabUIOgm.findElement(By.xpath("//a[@href = 'https://www.theathletesfoot.com.au/shop/hubs/fitness/clothing']"));
        LoginPage.syscoLabUIOgm.click(fitnessClothing);

        List<WebElement> products = LoginPage.syscoLabUIOgm.findElements(By.xpath("//a[@class='product-item-link']"));
        int categoryCount = products.size();
        System.out.println(categoryCount);

        Random random = new Random();
        int randomValue = random.nextInt(products.size());
        LoginPage.syscoLabUIOgm.moveToAndClick(products.get(randomValue));

        List<WebElement> productSize = LoginPage.syscoLabUIOgm.findElements(By.xpath("//div[@class='swatch-option text']"));
        int productSizeCount = productSize.size();
        System.out.println(productSizeCount);

        Random randomSize = new Random();
        int randomSizeValue = randomSize.nextInt(productSize.size());
        LoginPage.syscoLabUIOgm.scrollToElement(productSize.get(randomSizeValue));
        JavascriptExecutor executor = (JavascriptExecutor) LoginPage.syscoLabUIOgm.getDriver();
        executor.executeScript("arguments[0].click();", productSize.get(randomSizeValue));

        WebElement addToCartBtn = LoginPage.syscoLabUIOgm.findElement(By.id("product-addtocart-button"));
        LoginPage.syscoLabUIOgm.scrollToElement(addToCartBtn);
        LoginPage.syscoLabUIOgm.click(addToCartBtn);

        LoginPage.syscoLabUIOgm.setTimeOut(1000);

        LoginPage.syscoLabUIOgm.click(LoginPage.syscoLabUIOgm.findElement(By.xpath("//div[@class='minicart-wrapper']")));

        LoginPage.syscoLabUIOgm.setTimeOut(1000);
        WebElement viewCart = LoginPage.syscoLabUIOgm.getDriver().findElement(By.xpath("//*[@href='https://www.theathletesfoot.com.au/checkout/cart/']"));
        LoginPage.syscoLabUIOgm.scrollToElement(viewCart);
        JavascriptExecutor executor1 = (JavascriptExecutor) LoginPage.syscoLabUIOgm.getDriver();
        executor1.executeScript("arguments[0].click();", viewCart);
        //viewShoppingCart();

        WebElement product = LoginPage.syscoLabUIOgm.findElement(By.xpath("//td[@class='col item']//div//strong//a"));
        String productName = product.getText();
        System.out.println(productName);

        WebElement unitPrice = LoginPage.syscoLabUIOgm.findElement(By.xpath("//td[@class='col price']//span[@class='price']"));
        String productUnitPrice = unitPrice.getText();
        System.out.println(productUnitPrice);

        LoginPage.syscoLabUIOgm.setTimeOut(2000);
        WebElement secureCheckOutBtn = LoginPage.syscoLabUIOgm.findElement(By.xpath("//button[@title='Proceed to Checkout']"));
        LoginPage.syscoLabUIOgm.click(secureCheckOutBtn);

    }
}