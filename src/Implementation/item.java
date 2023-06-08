package Implementation;

import java.security.PrivateKey;

public class item {
    private double price;
    private int noOfItems;
    private String  itemName;

    public item(double price,int noOfItems) {
        this.price = price;
        this.noOfItems=noOfItems;
    }
    public item(double price,int noOfItems,String itemName) {
        this.price = price;
        this.noOfItems=noOfItems;
        this.itemName=itemName;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getItemName(){return this.itemName;}
}
