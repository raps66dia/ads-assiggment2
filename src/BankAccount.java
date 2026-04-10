
public class BankAccount {
    private int accountNumber;
    private String username;
    private int balance;

    public BankAccount (int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public int getAccountNumber() {return accountNumber;}
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {return username;}
    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {return balance;}
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString(){
        return "Account: " + username + " Balance: " + balance;
    }
    public void deposit(int money) {
        if (money > 0) {
            this.balance += money;

        }
    }
    public void withdraw(int money) {
        if (money > 0 && money <= this.balance) {
            this.balance -= money;
        } else {
            System.out.println("Not enough money or Invalid action");
        }
    }
}