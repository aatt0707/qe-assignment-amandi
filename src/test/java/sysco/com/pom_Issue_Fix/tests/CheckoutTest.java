package sysco.com.pom_Issue_Fix.tests;

import org.testng.annotations.Test;
import sysco.com.pom_Issue_Fix.functions.Checkout;
import sysco.com.pom_Issue_Fix.functions.Login;
import sysco.com.pom_Issue_Fix.utils.TestBase;

public class CheckoutTest extends TestBase {

    @Test
    public void validateCustomerDetails() {
        Checkout.validateCustomerDetails();
        Checkout.validateMandatoryFields();
        Checkout.fillMandatoryFields();
        Checkout.selectPaymentInformation();
        Login.quiteDriver();
    }

    @Test
    public void validateMandatoryFields() {
        //Checkout.validateMandatoryFields();
    }

    @Test
    public void fillMandatoryFields() {
        //Checkout.fillMandatoryFields();
    }

    @Test
    public void selectPaymentInformation() {
        //Checkout.selectPaymentInformation();
        //Login.quiteDriver();
    }
}
