package sysco.com.pom_Issue_Fix.functions;

import sysco.com.pom_Issue_Fix.pages.CartPage;

public class Cart {

    public static CartPage cartPage = new CartPage();
    public static void viewShoppingCart() throws Exception{
        cartPage.viewShoppingCart();
    }

    public static void manageShoppingCart(){
        cartPage.manageShoppingCart();
    }

    public static void addItemsToShoppingCart(){
        cartPage.addItemsToShoppingCart();
    }
}
