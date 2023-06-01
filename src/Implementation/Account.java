package Implementation;

public class Account {
    private double Balance;
    public Account(double amount){
        Balance=amount;

    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double amount) {
        Balance= amount;
    }

    public void transfer(double amount,Account x) throws InsufficientBalanceException {
        if(Balance>amount) {
            x.setBalance(x.getBalance() + amount);
            Balance -= amount;
        }
        else
            throw new InsufficientBalanceException();

    }
}