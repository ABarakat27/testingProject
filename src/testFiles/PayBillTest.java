package testFiles;

import Implementation.Account;
import org.junit.BeforeClass;

public class PayBillTest {
    static Account x ;

    @BeforeClass
    public static void start(){

        x=new Account(4000);
        System.out.println("start testing");
    }

}
