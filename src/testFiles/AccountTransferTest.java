
package testFiles;

import Implementation.Account;
import Implementation.InsufficientBalanceException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class AccountTransferTest {

    static Account x;
    static Account y;
    @BeforeClass
    public static void start() {

        x = new Account(4000);
        y=new Account(5000);
        System.out.println("start testing");
    }

    @Test
    public void transferTest() throws InsufficientBalanceException {


        y.transfer(2000, x);
        assertEquals(6000, x.getBalance(), 0.1);


    }

    @Test
    public void InsufficientBalance() throws InsufficientBalanceException {

        try {
            x.transfer(1000000, y);
        } catch (InsufficientBalanceException e) {
            assertEquals(6000,x.getBalance(),0.1);
        }

    }


}