package testFiles;

import Implementation.Account;
import Implementation.InsufficientBalanceException;
import Implementation.PaidException;
import Implementation.PayBill;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayBillTest {
    static Account x ;
    static PayBill pb;

    @BeforeClass
    public static void start(){

        x=new Account(4000);
        pb=new PayBill(500.0,"electricity");
        System.out.println("start testing");
    }
    @Test
    public void PayBillTest() throws InsufficientBalanceException, PaidException {
        try {
            x.payBill(pb);
            assertEquals(1500.0, x.getBalance(), 0.1);
        }
        catch (InsufficientBalanceException e){
            System.out.println("handle it");

        }
    }
}
