package testFiles;

import Implementation.*;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

public class NotifyUserTest {

    static Account a ;
    static Account b ;
    static  item i;
    @BeforeClass
    public static void start() throws InsufficientBalanceException {


        a = new Account(5000);
        b = new Account(5000);
        i =new item(15,3);
        a.transfer(100,b);
        a.BuyItem(i,2);

        System.out.println("start testing");
    }
    @org.junit.Test
    public void showNotificationsAfterTransfer() throws InsufficientBalanceException {

        assertEquals("A successful transaction has been made",a.getNotifications().get(0) );
    }
    @org.junit.Test
    public void showNotificationsAfterBuyingItem() throws InsufficientBalanceException {

        assertEquals("A successful transaction has been made",a.getNotifications().get(1) );
    }
}
