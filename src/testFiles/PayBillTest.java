package testFiles;

import Implementation.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayBillTest {
    static Account x ;
    static PayBill pb;
    static PayBill g;
    static Account l;
    static long startTime;
    static long stopTime;

    @BeforeClass
    public static void start(){

        startTime = System.nanoTime();
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

        }
        catch (PaidException|InsufficientBalanceException e ){

        }
        assertEquals(3500.0, x.getBalance(), 0.1);
    }


    @Test
    public void PayBillIPaidTest()  {
        try {
            x.payBill(pb);

        }
        catch (PaidException|InsufficientBalanceException e ){

        }
        assertEquals(3500.0, x.getBalance(), 0.1);
    }
    @Test
    public void PayBillInsufficientBalanceTest()  {
        try {

            l.payBill(g);
        }
        catch (PaidException|InsufficientBalanceException e ){

        }
        assertEquals(50.0, l.getBalance(), 0.1);
    }


    @AfterClass
    public static void end(){
        stopTime = System.nanoTime();
        System.out.println("Execution time of  PayBillTest in nano Seconds : "+(stopTime - startTime));
        System.out.println("End testing");
    }
}