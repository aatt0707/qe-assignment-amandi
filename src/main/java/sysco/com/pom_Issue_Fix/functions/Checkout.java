package sysco.com.pom_Issue_Fix.functions;

import sysco.com.pom_Issue_Fix.pages.CheckoutPage;

public class Checkout {

    public static CheckoutPage checkoutPage = new CheckoutPage();

    public static void validateCustomerDetails() {
        checkoutPage.validateCustomerDetails();
    }

    public static void validateMandatoryFields() {
        checkoutPage.validateMandatoryFields();
    }

    public static void fillMandatoryFields() {
        checkoutPage.fillMandatoryFields();
    }

    public static void selectPaymentInformation() {
        checkoutPage.selectPaymentInformation();
    }
}
