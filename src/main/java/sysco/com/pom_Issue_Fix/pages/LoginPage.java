package sysco.com.pom_Issue_Fix.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


/**
 * Created by Rifad on 5/21/18.
 */
public class LoginPage {
    public static SoftAssert softAssert = new SoftAssert();
    protected static SyscoLabUI syscoLabUIOgm;
    private By txtGoogleSearch = By.id("lst-ib");


    public static void loadLoginPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();

        //loading login page
        syscoLabUIOgm.setTimeOut(1000);
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(By.xpath("//a[@href = 'https://www.theathletesfoot.com.au/customer/account/login/']")));

    }

    public void validateLoginButton(){
        syscoLabUIOgm.setTimeOut(1000);

        Boolean isDisplayedLoginButton = syscoLabUIOgm.isDisplayed(syscoLabUIOgm.findElement(By.xpath("//button[@id='send2']")));
        softAssert.assertTrue(isDisplayedLoginButton,"Login button is not exists");

        syscoLabUIOgm.setTimeOut(1000);
        syscoLabUIOgm.scrollToElement(By.xpath("//button[@id='send2']"));
        WebElement loginBtn = syscoLabUIOgm.findElement(By.xpath("//button[@id='send2']"));
        syscoLabUIOgm.click(loginBtn);

        softAssert.assertAll();
    }

    public void validateLoginSectionValidations(){

        Boolean emailValidation = syscoLabUIOgm.isDisplayed(syscoLabUIOgm.findElement(By.id("email-error")));
        softAssert.assertTrue(emailValidation,"Validation message for email was not displayed");

        String errorMessage1 = syscoLabUIOgm.getText(syscoLabUIOgm.findElement(By.id("email-error")));
        softAssert.assertEquals(errorMessage1.equalsIgnoreCase("This is a required field."), true);

        Boolean passwordValidation = syscoLabUIOgm.isDisplayed(syscoLabUIOgm.findElement(By.id("pass-error")));
        softAssert.assertTrue(passwordValidation,"Validation message for password was not displayed");

        String errorMessage2 = syscoLabUIOgm.getText(syscoLabUIOgm.findElement(By.id("pass-error")));
        softAssert.assertEquals(errorMessage2.equalsIgnoreCase("This is a required field."), true);
        syscoLabUIOgm.setTimeOut(5000);
        syscoLabUIOgm.refreshBrowser();

        //validate incorrect credentials validation
        syscoLabUIOgm.sendKeys(By.id("email"), "abc");
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(By.xpath("//button[@id='send2']")));

        String errorMessage3 = syscoLabUIOgm.getText(syscoLabUIOgm.findElement(By.id("email-error")));
        softAssert.assertEquals(errorMessage3.equalsIgnoreCase("Please enter a valid email address (Ex: johndoe@domain.com)."), true);

        softAssert.assertAll();
    }

    public void customerLogin(String userName, String password){
        syscoLabUIOgm.setTimeOut(1000);
        syscoLabUIOgm.sendKeys(By.id("email"), userName);
        syscoLabUIOgm.sendKeys(By.id("pass"), password);
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(By.xpath("//button[@id='send2']")));
    }

    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }


    public void enterText(String searchString) {
        syscoLabUIOgm.sendKeys(txtGoogleSearch, searchString);
    }

}
