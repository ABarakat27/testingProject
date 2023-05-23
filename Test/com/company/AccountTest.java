package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class AccountTest {
    Account x= new Account(1,2000);
    Account y=new Account(1,3000);
    Account z=new Account(1,5000);



    @BeforeClass
    public static void start(){

        System.out.println("start testing");
    }
    @Before
    public void startTest(){
        System.out.println("Start testcase..");
    }
    @After
    public void endTest(){
        System.out.println("end testcase..");
    }
    @Test

    public void transfer(){

       x.transfer(1000,y);
       x.receiveTransfer(1000,y);

       z.transfer(1000,y);

       assertEquals(4000,y.getBalance(),0);

    }

    @Test
    public void withdraw() {
        x.deposit(2000);
        x.withdraw(1000);
        assertEquals(3000,x.getBalance(),0);




    }
    @Test
    public void receiveTransfer(){
        x.receiveTransfer(1000,y);

        assertEquals(3000,x.getBalance(),0);
    }


    @Test
    public void payBill(){

    z.payBill(2000,"ElectricityBill");
    assertEquals(3000,z.getBalance(),0);

    }
    @Test
    public void isClosed(){
        x.closeAccount();
        assertEquals(true,x.isClosed());


    }




    @AfterClass
    public static void end(){
        System.out.println("End testing");
    }
}
