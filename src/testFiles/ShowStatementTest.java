package testFiles;

import Implementation.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShowStatementTest {



    static Account a ;
    static Account b ;
    static PayBill p ;
    static item i ;
    static long startTime;
    static long stopTime;
    @BeforeClass
    public static void start(){

        startTime = System.nanoTime();
        a =new Account(5000) ;
        b =new Account(5000) ;
        p=new PayBill(15,"Gas");
        i=new item(15,2);
        System.out.println("start testing");
    }
    @org.junit.Test
    public void showBankStatementTransfer() {
        try {
            a.transfer(3000, b);

        }catch (InsufficientBalanceException e){

        }
        assertEquals("transfer",a.getStatements().get("transfer").get(0).getOperationType());
        assertEquals("3000.0",a.getStatements().get("transfer").get(0).getAmount());
        assertNotNull(a.getStatements().get("transfer").get(0).getAmount());
    }
    @org.junit.Test
    public void showBankStatementPayBill() {
        try {
            a.payBill(p);

        }catch (PaidException|InsufficientBalanceException e){

        }
        assertEquals("PayBill",a.getStatements().get("PayBill").get(0).getOperationType());
        assertEquals("15.0",a.getStatements().get("PayBill").get(0).getAmount());
        assertNotNull(a.getStatements().get("PayBill").get(0).getAmount());
    }
    @org.junit.Test
    public void showBankStatementBuyItem() {
        try {
            a.BuyItem(i,2);

        }catch (noOfItemsException|InsufficientBalanceException e){

        }
        assertEquals("BuyItem",a.getStatements().get("BuyItem").get(0).getOperationType());
        assertEquals("30.0",a.getStatements().get("BuyItem").get(0).getAmount());
        assertNotNull(a.getStatements().get("BuyItem").get(0).getAmount());
    }
    @AfterClass
    public static void end(){
        stopTime = System.nanoTime();
        System.out.println("Execution time of  ShowStatementTest in nano Seconds : "+(stopTime - startTime));
        System.out.println("End testing");
    }
}
