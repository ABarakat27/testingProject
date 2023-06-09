
package testFiles;

import Implementation.Account;
import Implementation.InsufficientBalanceException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class AccountTransferTest {

    static Account x;
    static Account y;
    static long startTime;
    static long stopTime;
    @BeforeClass
    public static void start() {
        startTime = System.nanoTime();


        x = new Account(4000);
        y=new Account(5000);
        System.out.println("start testing");
    }

    @Test
    public void transferTest()  {

        try{
            y.transfer(2000, x);

        }catch(InsufficientBalanceException e){

        }
        assertEquals(6000, x.getBalance(), 0.1);



    }

    @Test
    public void InsufficientBalance()  {

        try {
            x.transfer(1000000, y);


        } catch (InsufficientBalanceException e) {

        }
        assertEquals(6000,x.getBalance(),0.1);
    }

    @Test
    public void negativeTransfer()  {

        try {
            x.transfer(-11, y);


        } catch (InsufficientBalanceException e) {

        }
        assertEquals(6000,x.getBalance(),0.1);
    }
    @AfterClass
    public static void end(){
        stopTime = System.nanoTime();
        System.out.println("Execution time of  AccountTransferTest in nano Seconds : "+(stopTime - startTime));
        System.out.println("End testing");
    }

}