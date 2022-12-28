package sysco.com.pom_Issue_Fix.tests;

import org.testng.annotations.Test;
import sysco.com.pom_Issue_Fix.functions.MyAccount;
import sysco.com.pom_Issue_Fix.utils.TestBase;

public class MyAccountTest extends TestBase {
    @Test(priority = 2)
    public void validateMyAccount() throws Exception{
        MyAccount.getPageTitle();
        MyAccount.validateCustomerName();
    }

}
