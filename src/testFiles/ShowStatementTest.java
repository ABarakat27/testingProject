package testFiles;

import Implementation.*;
import org.junit.BeforeClass;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShowStatementTest {



    static BankStatement s ;
    @BeforeClass
    public static void start(){
        ArrayList<String> sB =new ArrayList<String>() ;
        sB.add("transfer");

        s = new BankStatement(sB);


        System.out.println("start testing");
    }
    @org.junit.Test
    public void showBankStatement() {
        assertEquals("transfer", s.getOperationType());
    }

}
