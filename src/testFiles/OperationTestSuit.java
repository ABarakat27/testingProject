package testFiles;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;
@RunWith(Suite.class)
@Suite.SuiteClasses({
       AccountTransferTest.class,
        BuyItemTest.class,
        PayBillTest.class
})
public class OperationTestSuit {
}
