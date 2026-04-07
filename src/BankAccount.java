
public class BankAccount {
    private String accountNumber;
    private String username;
    private int balance;

    public BankAccount (String accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String getAccountNumber() {return accountNumber;}
    public void setAccountNumber(String accountNumber) {
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
}
