package testFiles;

import Implementation.Account;
import Implementation.InsufficientBalanceException;
import Implementation.item;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyItemTest {
    static Account x ;
    static  item y;
    @BeforeClass
    public static void start(){

        x=new Account(4000);
        y=new item(200,10);
        System.out.println("start testing");
    }
    @Test
    public void BuyItemTest() throws InsufficientBalanceException {

        x.BuyItem(y,5);
        assertEquals(3000,x.getBalance(),0.1);



    }
    @Test
    public void InsufficientBalance() throws InsufficientBalanceException {


        try {
            new Account(0).BuyItem(new item(8000, 10), 1);// dont know if it is written like that or not
        }
        catch (InsufficientBalanceException e){
            System.out.println("handle it ");

        }
    }
    }
