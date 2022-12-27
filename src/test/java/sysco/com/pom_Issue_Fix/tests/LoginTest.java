package sysco.com.pom_Issue_Fix.tests;


import sysco.com.pom_Issue_Fix.data.LoginData;
import sysco.com.pom_Issue_Fix.functions.Login;
import sysco.com.pom_Issue_Fix.utils.ExcelUtil;
import sysco.com.pom_Issue_Fix.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        // Sample way to retrive data from excel
        LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Login.loadLoginPage();
        Login.validateLoginButton();
        Login.validateLoginSectionValidations();
        Login.customerLogin();

    }
}