package testFiles;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        OperationTestSuit.class,
        DataOfTransactionsTestSuit.class,

})
public class SystemTestSuite {
}
