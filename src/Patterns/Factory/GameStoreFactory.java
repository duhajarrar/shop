package Patterns.Factory;

import Models.Store;
import Models.Stores.GameStore;

public class GameStoreFactory implements StoreFactory {

    private static GameStoreFactory instance;
    ItemFactory gameFactory;
    
    private GameStoreFactory() {
        this.gameFactory = PuzzleFactory.getInstance();
    }

    public static GameStoreFactory getInstance() {
        if (instance == null) {
            instance = new GameStoreFactory();
        }
        return instance;
    }
    
    @Override
    public Store createStore(String storeName) {
        return new GameStore(storeName);
    }

    public ItemFactory getItemFactory() {
        return gameFactory;
    }

    
    
    
}
