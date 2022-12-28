package sysco.com.pom_Issue_Fix.tests;

import org.testng.annotations.Test;
import sysco.com.pom_Issue_Fix.functions.Cart;
import sysco.com.pom_Issue_Fix.utils.TestBase;

public class CartTest extends TestBase {
    @Test
    public void manageCart() throws Exception {
        Cart.viewShoppingCart();
        Cart.manageShoppingCart();
        Cart.addItemsToShoppingCart();
    }


}
