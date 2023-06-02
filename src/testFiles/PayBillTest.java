package testFiles;

import Implementation.*;
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
            assertEquals(3500.0, x.getBalance(), 0.1);
        }
        catch (InsufficientBalanceException e ){
            System.out.println("not enough Balance ");

        }
        catch (PaidException e){

            System.out.println("already paid");

        }



    }


}