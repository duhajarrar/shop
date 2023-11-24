package Patterns.Factory;

import Models.Item;
import Models.Items.Puzzle;

public class PuzzleFactory implements ItemFactory {

    private static PuzzleFactory instance;

    private PuzzleFactory() {}

    public static PuzzleFactory getInstance() {
        if (instance == null) {
            instance = new PuzzleFactory();
        }
        return instance;
    }
    
    @Override
    public Item createItem(String itemName, int storeId, double price) {
        return new Puzzle(itemName,storeId,price);
    }
    
}
