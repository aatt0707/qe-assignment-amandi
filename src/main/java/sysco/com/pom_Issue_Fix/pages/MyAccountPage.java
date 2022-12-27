package sysco.com.pom_Issue_Fix.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyAccountPage {
    protected static SyscoLabUI syscoLabUIOgm;
    public static SoftAssert softAssert = new SoftAssert();

    public void getPageTitle(){


        String pageTitle = LoginPage.syscoLabUIOgm.getTitle();
        System.out.println(pageTitle);
        softAssert.assertEquals(pageTitle.equalsIgnoreCase("My Account"),true);
        softAssert.assertAll();
    }

    public void validateCustomerName(){

        LoginPage.syscoLabUIOgm.waitTillElementLoaded(By.xpath("//li[@class ='nav item -rewards rewards-block']//div[@class = 'title']"));
        String title = LoginPage.syscoLabUIOgm.findElement(By.xpath("//li[@class ='nav item -rewards rewards-block']//div[@class = 'title']")).getText();
        String customerName = title.substring(3,17);
        softAssert.assertEquals(customerName.equalsIgnoreCase("TERRY ANDERSON"),true);
        softAssert.assertAll();
    }


}
