package testFiles;

import Implementation.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotifyUserTest {

    static Account a ;
    static Account b ;
    static  item i;
    static  PayBill pb;
    static  PayBill g;
    static long startTime;
    static long stopTime;
    @BeforeClass
    public static void start()  {
        startTime = System.nanoTime();
     a = new Account(5000);
     b = new Account(5000);
     i = new item(15, 3);
     pb = new PayBill(15, "Gas");
     g = new PayBill(15000, "shawrma");


        System.out.println("start testing");
    }
    @Test
    public void showNotificationsAfterTransfer()  {
        try {

            a.transfer(100, b);

        }catch (InsufficientBalanceException e){

        }
        assertEquals("A successful transaction has been made",a.getNotifications().get(1) );
    }
    @Test
    public void showNotificationsAfterBuyingItem()  {

        try {

            a.BuyItem(i, 2);

        }catch (noOfItemsException|InsufficientBalanceException e){

        }
        assertEquals("A successful transaction has been made",a.getNotifications().get(0) );
    }

    @Test
    public void showNotificationsPayBill()  {
    try{

        a.payBill(pb);

    }catch(InsufficientBalanceException |PaidException e) {

    }
        assertEquals("A successful transaction has been made",a.getNotifications().get(2) );
    }
    @Test
    public void showNotificationsPayBillFailedIsPaid()  {
        try{
            a.payBill(pb);

        }catch(InsufficientBalanceException |PaidException e) {

        }
        assertEquals("A failed transaction has been made", a.getNotifications().get(4));
    }
    @Test
    public void showNotificationsPayBillFailedBalance()  {
        try{
            a.payBill(g);

        }catch(InsufficientBalanceException |PaidException e) {

        }
        assertEquals("A failed transaction has been made", a.getNotifications().get(3));
    }

    @AfterClass
    public static void end(){
        stopTime = System.nanoTime();
        System.out.println("Execution time of  NotifyUserTest in nano Seconds : "+(stopTime - startTime));
        System.out.println("End testing");
    }
}
