package sysco.com.pom_Issue_Fix.functions;

import sysco.com.pom_Issue_Fix.common.Constants;
import sysco.com.pom_Issue_Fix.pages.LoginPage;
import sysco.com.pom_Issue_Fix.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Login {

    public static LoginPage loginPage = new LoginPage();


    public static void loadLoginPage() {
        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            loginPage.loadLoginPage(capabilities, Constants.APP_URL);
        } else {
            loginPage.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public static void validateLoginButton() {
        loginPage.validateLoginButton();
    }

    public static void validateLoginSectionValidations() {
        loginPage.validateLoginSectionValidations();
    }

    public static void customerLogin() {
        loginPage.customerLogin();
    }

    public static void quiteDriver() {
        loginPage.quitDriver();
    }

    public static void searchGoogle() {
        loginPage.enterText("Apple");
    }
}
