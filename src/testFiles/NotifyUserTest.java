package testFiles;

import Implementation.*;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

public class NotifyUserTest {

    static Account a ;
    static Account b ;
    static  item i;
    static  PayBill pb;
    @BeforeClass
    public static void start() throws InsufficientBalanceException, PaidException {

 try {
     a = new Account(5000);
     b = new Account(5000);
     i = new item(15, 3);
     pb = new PayBill(15, "Gas");
     a.transfer(100, b);
     a.BuyItem(i, 2);
     a.payBill(pb);


 }catch (InsufficientBalanceException | PaidException | noOfItemsException e){

        }
        System.out.println("start testing");
    }
    @org.junit.Test
    public void showNotificationsAfterTransfer()  {

        assertEquals("A successful transaction has been made",a.getNotifications().get(0) );
    }
    @org.junit.Test
    public void showNotificationsAfterBuyingItem()  {

        assertEquals("A successful transaction has been made",a.getNotifications().get(1) );
    }
    @org.junit.Test
    public void showNotificationsPayBill()  {

        assertEquals("A successful transaction has been made",a.getNotifications().get(2) );
    }
    @org.junit.Test
    public void showNotificationsPayBillFailed()  {
    try{
        a.payBill(pb);
    }catch(InsufficientBalanceException |PaidException e) {
        assertEquals("A failed transaction has been made", a.getNotifications().get(3));
    }
    }


}
