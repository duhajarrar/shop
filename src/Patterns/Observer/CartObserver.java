package Patterns.Observer;

import Models.ShoppingCart;

public interface CartObserver {
    void update(ShoppingCart shoppingCart);
}
