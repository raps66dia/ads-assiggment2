import java.util.Stack;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;

public class BankSystem {
    LinkedList<BankAccount> accounts = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    Stack<String> history = new Stack<>();
    Queue<String> billQueue = new LinkedList<>();
    Queue<BankAccount> accountRequests = new LinkedList<>();
    BankAccount[] dataAccount = new BankAccount[3];
    public void main(String[] args) {
        dataAccount[0] = new BankAccount(101, "Ali", 150000);
        dataAccount[1] = new BankAccount(102, "Ilyas", 200000);
        dataAccount[2] = new BankAccount(103, "Almas", 67000);

        while (true) {
            System.out.println("--- Bank System ---");
            System.out.println("1. Add a new account (Request)");
            System.out.println("2. Show all accounts");
            System.out.println("3. Search account by username");
            System.out.println("4. Add to deposit");
            System.out.println("5. Withdraw money");
            System.out.println("6. Exit");
            System.out.println("7. Last transaction");
            System.out.println("8. Undo transaction");
            System.out.println("9. Add bill payment");
            System.out.println("10. Process bill");
            System.out.println("11. Show All bills");
            System.out.println("12. Approve account");
            System.out.println("13. Display all request");
            System.out.println("14. Static accounts");
            System.out.println("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    allAccounts();
                    break;
                case 3:
                    searchByUsername();
                    break;
                case 4:
                    depositMoney();
                    break;
                case 5:
                    withdrawMoney();
                    break;
                case 6:
                    System.out.println("Bye");
                    return;
                case 7:
                    lastTransaction();
                    break;
                case 8:
                    undoTransaction();
                    break;
                case 9:
                    addBill();
                    break;
                case 10:
                    processBill();
                    break;
                case 11:
                    showQueue();
                    break;
                case 12:
                    processAccountRequest();
                    break;
                case 13:
                    displayRequests();
                    break;
                case 14:
                    printAcc();
                    break;
                default:
                    System.out.println("Invalid action");
            }
        }
    }
    public void addAccount() {
        System.out.println("Enter account number: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter balance: ");
        int balance = sc.nextInt();

        accountRequests.add(new BankAccount(id, username, balance));
        System.out.println("Request send! Waiting for Admin");
    }
    public void allAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        System.out.println("Accounts List: ");
        for (int i = 0; i < accounts.size(); i++){
            System.out.println((i + 1) + ". " + accounts.get(i));
        }
    }
    public void searchByUsername() {
        System.out.println("Enter username: ");
        String name = sc.nextLine();
        boolean found = false;
        for(BankAccount acc : accounts) {
            if (acc.getUsername().equalsIgnoreCase(name)) {
                System.out.println("Found: " + acc);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found");
        }
    }
    public void depositMoney() {
        System.out.println("Enter username of acc: ");
        String name = sc.nextLine();

        boolean found = false;

        for (BankAccount acc : accounts) {
            if (acc.getUsername().equalsIgnoreCase(name)) {
                System.out.println("Deposit amount: ");
                int amount = sc.nextInt();

                acc.deposit(amount);

                System.out.println("Deposit " + amount + " to " + name);
                String action = "Deposit: " + amount + " to " + name;
                history.push(action);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found");
        }
    }
    public void withdrawMoney() {
        System.out.println("Enter account username: ");
        String name = sc.nextLine();

        boolean found = false;
        for (BankAccount acc : accounts) {
            if (acc.getUsername().equalsIgnoreCase(name)) {
                System.out.println("Withdraw amount: ");
                int amount = sc.nextInt();

                acc.withdraw(amount);
                System.out.println("Withdraw " + amount + " from " + name);
                String action = "Withdraw " + amount + " to " + name;
                history.push(action);
                found = true;
                break;
            }
         }
        if (!found) {
            System.out.println("Invalid amount or not enough for withdraw");
        }
    }
    public void lastTransaction() {
        if(!history.isEmpty()) {
            System.out.println("Last transaction: " + history.peek());
        } else {
            System.out.println("History is empty");
        }
    }
    public void undoTransaction() {
        if (!history.isEmpty()) {
            String removed = history.pop();
            System.out.println("Undo -> " + removed + " removed");
        } else {
            System.out.println("Nothing to undo");
        }
    }
    public void addBill() {
        System.out.println("Enter a bill: ");
        String bill = sc.nextLine();
        billQueue.add(bill);
        System.out.println("Added: " + bill);
    }
    public void processBill() {
        if(billQueue.isEmpty()) {
            System.out.println("No bill in process");
            return;
        }
        String processed = billQueue.poll();
        System.out.println("Processing: " + processed);
        if (!billQueue.isEmpty()) {
            System.out.println("Remaining: " + billQueue);
        }
    }
    public void showQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills in queue");
        } else {
            System.out.println("Bills in queue: " + billQueue);
        }
    }
    public void processAccountRequest() {
        if (accountRequests.isEmpty()) {
            System.out.println("No requests");
            return;
        }
        BankAccount approvedAcc = accountRequests.poll();
        accounts.add(approvedAcc);
        System.out.println("Success for: " + approvedAcc.getUsername());
        System.out.println("Account is ready");
    }
    public void displayRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("No requests");
        } else {
            System.out.println("---All requests---");
            for (BankAccount request : accountRequests) {
                System.out.println("- " + request.getUsername() + " (Initial: " + request.getBalance() + ")");
            }
        }

    }
    public void printAcc() {
        for (int i = 0; i < dataAccount.length; i++) {
            System.out.println("Static Accounts: " + dataAccount[i]);
        }
    }

}