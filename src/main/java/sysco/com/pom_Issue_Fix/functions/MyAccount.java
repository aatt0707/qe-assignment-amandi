package sysco.com.pom_Issue_Fix.functions;


import sysco.com.pom_Issue_Fix.pages.MyAccountPage;


public class MyAccount {
    public static MyAccountPage myAccount = new MyAccountPage();

    public static void getPageTitle() {
        myAccount.getPageTitle();
    }

    public static void validateCustomerName() {
        myAccount.validateCustomerName();
    }

}
