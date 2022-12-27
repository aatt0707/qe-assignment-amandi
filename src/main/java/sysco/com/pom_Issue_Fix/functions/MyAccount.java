package sysco.com.pom_Issue_Fix.functions;

import org.openqa.selenium.remote.DesiredCapabilities;
import sysco.com.pom_Issue_Fix.common.Constants;
import sysco.com.pom_Issue_Fix.pages.MyAccountPage;
import sysco.com.pom_Issue_Fix.utils.DriverSetUpUtil;

public class MyAccount {
    public static MyAccountPage myAccount = new MyAccountPage();

    public static void getPageTitle(){
        myAccount.getPageTitle();
    }

    public static void validateCustomerName(){
        myAccount.validateCustomerName();
    }

}
