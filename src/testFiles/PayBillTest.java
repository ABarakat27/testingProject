package testFiles;

import Implementation.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayBillTest {
    static Account x ;
    static PayBill pb;
    static PayBill g;
    static Account l;
    @BeforeClass
    public static void start(){

        x=new Account(4000);
        pb=new PayBill(500.0,"electricity");
        g=new PayBill(5000.0,"gas");
        l =new Account(50);
        System.out.println("start testing");
    }
    @Test
    public void PayBillTest()  {
        try {
            x.payBill(pb);
            assertEquals(3500.0, x.getBalance(), 0.1);
        }
        catch (PaidException|InsufficientBalanceException e ){

        }

    }


    @Test
    public void PayBillIPaidTest()  {
        try {
            x.payBill(pb);

        }
        catch (PaidException|InsufficientBalanceException e ){
            assertEquals(3500.0, x.getBalance(), 0.1);
        }

    }
    @Test
    public void PayBillInsufficientBalanceTest()  {
        try {

            l.payBill(g);
        }
        catch (PaidException|InsufficientBalanceException e ){
            assertEquals(50.0, l.getBalance(), 0.1);
        }

    }

}