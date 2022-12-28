package sysco.com.pom_Issue_Fix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class CheckoutPage {

    public SoftAssert softAssert = new SoftAssert();

    public void validateCustomerDetails(){
        WebElement firstName = LoginPage.syscoLabUIOgm.findElement(By.xpath("//input[@name='firstname']"));
        softAssert.assertEquals(firstName.getAttribute("value"), "Terry");

        WebElement lastName = LoginPage.syscoLabUIOgm.findElement(By.xpath("//input[@name='lastname']"));
        softAssert.assertEquals(lastName.getAttribute("value"), "Anderson");
        softAssert.assertAll();
    }

    public void validateMandatoryFields(){

        WebElement continueBtn = LoginPage.syscoLabUIOgm.findElement(By.xpath("//button[@title='Continue']"));
        LoginPage.syscoLabUIOgm.scrollToElement(continueBtn);
        JavascriptExecutor executor = (JavascriptExecutor)LoginPage.syscoLabUIOgm.getDriver();
        executor.executeScript("arguments[0].click();", continueBtn);

        WebElement addressFieldValidation = LoginPage.syscoLabUIOgm.findElement(By.xpath("(//div[@class='field-error mage-error'])[1]"));
        addressFieldValidation.isDisplayed();
        softAssert.assertTrue(addressFieldValidation.isDisplayed(),"Validation for Address field not displayed");

        WebElement subUrbFieldValidation = LoginPage.syscoLabUIOgm.findElement(By.xpath("(//div[@class='field-error mage-error'])[2]"));
        subUrbFieldValidation.isDisplayed();
        softAssert.assertTrue(subUrbFieldValidation.isDisplayed(),"Validation for Suburb field not displayed");

        WebElement stateProvinceFieldValidation = LoginPage.syscoLabUIOgm.findElement(By.xpath("(//div[@class='field-error mage-error'])[3]"));
        stateProvinceFieldValidation.isDisplayed();
        softAssert.assertTrue(stateProvinceFieldValidation.isDisplayed(),"Validation for State/Province field not displayed");

        WebElement postCodeFieldValidation = LoginPage.syscoLabUIOgm.findElement(By.xpath("(//div[@class='field-error mage-error'])[4]"));
        postCodeFieldValidation.isDisplayed();
        softAssert.assertTrue(postCodeFieldValidation.isDisplayed(),"Validation for PostCode field not displayed");

        WebElement phoneNumberFieldValidation = LoginPage.syscoLabUIOgm.findElement(By.xpath("(//div[@class='field-error mage-error'])[5]"));
        phoneNumberFieldValidation.isDisplayed();
        softAssert.assertTrue(phoneNumberFieldValidation.isDisplayed(),"Validation for Phone Number field not displayed");
    }

    public void fillMandatoryFields(){
        WebElement inputPostCode = LoginPage.syscoLabUIOgm.findElement(By.xpath("//input[@name='postcode']"));
        inputPostCode.sendKeys("2000");
        WebElement code = LoginPage.syscoLabUIOgm.findElement(By.xpath("(//a[@class='link ui-corner-all'])[3]"));
        LoginPage.syscoLabUIOgm.scrollToElement(code);
        LoginPage.syscoLabUIOgm.moveToAndClick(code);

        WebElement inputAddress = LoginPage.syscoLabUIOgm.findElement(By.xpath("//input[@name='street[0]']"));
        LoginPage.syscoLabUIOgm.sendKeys(inputAddress,"Bakers Street");

        WebElement inputPhoneNumber = LoginPage.syscoLabUIOgm.findElement(By.xpath("//div[@class='placeholder-wrapper-au']"));
        LoginPage.syscoLabUIOgm.moveToAndClick(inputPhoneNumber);
        WebElement inputTelephone = LoginPage.syscoLabUIOgm.findElement(By.xpath("//input[@name='telephone']"));
        LoginPage.syscoLabUIOgm.sendKeys(inputTelephone,"999999999");
        LoginPage.syscoLabUIOgm.findElement(By.xpath("//html")).click();

        LoginPage.syscoLabUIOgm.setTimeOut(2000);
        WebElement continueBtn = LoginPage.syscoLabUIOgm.findElement(By.xpath("//button[@title='Continue']"));
        LoginPage.syscoLabUIOgm.scrollToElement(continueBtn);
        JavascriptExecutor executor = (JavascriptExecutor)LoginPage.syscoLabUIOgm.getDriver();
        executor.executeScript("arguments[0].click();", continueBtn);


    }

    public void selectPaymentInformation(){
        WebElement ccOption = LoginPage.syscoLabUIOgm.findElement(By.xpath("//input[@id='braintree']"));
        JavascriptExecutor executor = (JavascriptExecutor)LoginPage.syscoLabUIOgm.getDriver();
        executor.executeScript("arguments[0].click();", ccOption);

        WebElement frameElement = LoginPage.syscoLabUIOgm.findElement(By.xpath("//iframe[@name='braintree-hosted-field-number']"));
        LoginPage.syscoLabUIOgm.switchToFrame(frameElement);

        WebElement creditCardNumber = LoginPage.syscoLabUIOgm.findElement(By.xpath("//form//input[@id='credit-card-number']"));
        LoginPage.syscoLabUIOgm.sendKeys(creditCardNumber,"8889876756378862");
        LoginPage.syscoLabUIOgm.switchToDefaultFrame();

        WebElement frameElement2 = LoginPage.syscoLabUIOgm.findElement(By.xpath("//iframe[@name='braintree-hosted-field-expirationDate']"));
        LoginPage.syscoLabUIOgm.switchToFrame(frameElement2);
        WebElement inputExpirationMonth = LoginPage.syscoLabUIOgm.findElement(By.xpath("//form//input[@id='expiration']"));
        LoginPage.syscoLabUIOgm.sendKeys(inputExpirationMonth,"109999");
        LoginPage.syscoLabUIOgm.switchToDefaultFrame();

        WebElement creditCardFieldValidation = LoginPage.syscoLabUIOgm.findElement(By.xpath("//div[@class='hosted-error']//span[contains(text(),'Please, enter valid Credit Card Number')]"));
        softAssert.assertTrue(creditCardFieldValidation.isDisplayed(),"Credit card validation message was not displayed");

        WebElement frameElement3 = LoginPage.syscoLabUIOgm.findElement(By.xpath("//iframe[@name='braintree-hosted-field-cvv']"));
        LoginPage.syscoLabUIOgm.switchToFrame(frameElement3);
        WebElement inputCvv = LoginPage.syscoLabUIOgm.findElement(By.xpath("//form//input[@id='cvv']"));
        LoginPage.syscoLabUIOgm.sendKeys(inputCvv,"1234");
        LoginPage.syscoLabUIOgm.switchToDefaultFrame();

        WebElement expirationFieldValidation = LoginPage.syscoLabUIOgm.findElement(By.xpath("//div[@class='hosted-error']//span[contains(text(),'Please, enter valid Expiration Date')]"));
        softAssert.assertTrue(expirationFieldValidation.isDisplayed(),"Expiration validation message was not displayed");
        softAssert.assertAll();
    }
}
