package Models;

public abstract class Item {
    private static int counter = 0;
    private final int itemId;
    private String itemName;
    private int storeId;
    private double price;

    public Item(String itemName, int storeId, double price) {
        this.itemId = counter;
        this.itemName = itemName;
        this.storeId = storeId;
        this.price = price;
        counter ++;
    }


    public int getItemId() {
        return itemId;
    }


    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public int getStoreId() {
        return storeId;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Item [itemId=" + itemId + ", itemName=" + itemName + ", storeId=" + storeId + ", price=" + price + "]";
    }    
    
}
