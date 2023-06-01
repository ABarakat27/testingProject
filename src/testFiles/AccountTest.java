
package testFiles;

import Implementation.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AccountTest {

    @Test
    public void transferTest() throws InsufficientBalanceException {
        Account x=new Account(1000);
        Account y=new Account(5000);
        y.transfer(2000,x);
        assertEquals(3000,x.getBalance(),0.1);



    }
    @Test(expected = InsufficientBalanceException.class)
    public void InsufficientBalance() throws InsufficientBalanceException {


        new Account(0).transfer(1000,new Account(1000));
    }


}
