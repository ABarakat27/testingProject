package Implementation;

public class item {
    private double price;
    private int noOfItems;

    public item(double price,int noOfItems) {
        this.price = price;
        this.noOfItems=noOfItems;
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
}
