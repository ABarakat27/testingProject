package testFiles;

import Implementation.Account;
import Implementation.InsufficientBalanceException;
import Implementation.item;
import Implementation.noOfItemsException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyItemTest {
    static Account x ;
    static  item y;
    static  item g;
    @BeforeClass
    public static void start(){

        x=new Account(4000);
        y=new item(200,10);
        g =new item(5000,1);
        System.out.println("start testing");
    }
    @Test
    public void BuyItemTest() {
            try {
                x.BuyItem(y, 5);

            }catch(InsufficientBalanceException|noOfItemsException e){

            }

        assertEquals(3000, x.getBalance(), 0.1);
        assertEquals(5, y.getNoOfItems());


    }
    @Test
    public void InsufficientBalance() {


        try {
            x.BuyItem(g, 1);

        }catch(InsufficientBalanceException|noOfItemsException e){

        }
        assertEquals(4000, x.getBalance(), 0.1);
        assertEquals(1, g.getNoOfItems());
    }

    @Test
    public void InsufficientNoItems() {


        try {
            x.BuyItem(g, 20);

        }catch(InsufficientBalanceException|noOfItemsException e){

        }
        assertEquals(4000, x.getBalance(), 0.1);
        assertEquals(1, g.getNoOfItems());
    }
    @Test
    public void NegativeNoItems() {


        try {
            x.BuyItem(y, -4);

        }catch(InsufficientBalanceException|noOfItemsException e){

        }
        assertEquals(4000, x.getBalance(), 0.1);
        assertEquals(10, y.getNoOfItems());
    }

}

