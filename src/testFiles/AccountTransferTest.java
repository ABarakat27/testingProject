
package testFiles;

import Implementation.Account;
import Implementation.InsufficientBalanceException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class AccountTransferTest {

    static Account x;

    @BeforeClass
    public static void start() {

        x = new Account(4000);
        System.out.println("start testing");
    }

    @Test
    public void transferTest() throws InsufficientBalanceException {
        Account x = new Account(1000);
        Account y = new Account(5000);
        y.transfer(2000, x);
        assertEquals(3000, x.getBalance(), 0.1);


    }

    @Test
    public void InsufficientBalance() throws InsufficientBalanceException {

        try {
            new Account(0).transfer(1000, new Account(1000));
        } catch (InsufficientBalanceException e) {
            System.out.println("handle it");
        }

    }


}