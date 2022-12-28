package sysco.com.pom_Issue_Fix.tests;

import org.testng.annotations.Test;
import sysco.com.pom_Issue_Fix.functions.Cart;
import sysco.com.pom_Issue_Fix.utils.TestBase;

public class CartTest extends TestBase {
    @Test(priority = 3)
    public void viewCart() throws Exception {
        Cart.viewShoppingCart();
    }

    @Test(priority = 4)
    public void manageShoppingCart() throws Exception {
        Cart.manageShoppingCart();
    }

    @Test(priority = 5)
    public void addingItems() throws Exception {
        Cart.addItemsToShoppingCart();
    }


}
