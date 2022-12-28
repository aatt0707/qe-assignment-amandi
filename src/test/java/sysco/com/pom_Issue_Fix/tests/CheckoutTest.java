package sysco.com.pom_Issue_Fix.tests;

import org.testng.annotations.Test;
import sysco.com.pom_Issue_Fix.functions.Checkout;
import sysco.com.pom_Issue_Fix.functions.Login;
import sysco.com.pom_Issue_Fix.utils.TestBase;

public class CheckoutTest extends TestBase {

    @Test(priority = 6)
    public void validateCustomerDetails() {
        Checkout.validateCustomerDetails();
    }

    @Test(priority = 7)
    public void validateMandatoryFields() {
        Checkout.validateMandatoryFields();
    }

    @Test(priority = 8)
    public void fillMandatoryFields() {
        Checkout.fillMandatoryFields();
    }

    @Test(priority = 9)
    public void selectPaymentInformation() {
        Checkout.selectPaymentInformation();
        Login.quiteDriver();
    }
}
