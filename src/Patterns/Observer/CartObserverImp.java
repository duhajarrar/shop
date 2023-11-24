package Patterns.Observer;

import Models.ShoppingCart;

public class CartObserverImp implements CartObserver{

    @Override
    public void update(ShoppingCart shoppingCart) {
        System.out.println("Cart has been updated. Current items: " + shoppingCart.getItems());

    }
}
