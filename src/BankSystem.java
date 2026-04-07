import java.util.LinkedList;
import java.util.Scanner;

public class BankSystem {
    LinkedList<BankAccount> accounts = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    public void main(String[] args) {

        while (true) {
            System.out.println("--- Bank System ---");
            System.out.println("1. Add a new account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Search account by username");
            System.out.println("4. Exit");
            System.out.println("Select an option (1/2/3/4): ");

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
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Invalid action");
            }
        }
    }
    public void addAccount() {
        System.out.println("Enter account number: ");
        String id = sc.nextLine();
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter balance: ");
        int balance = sc.nextInt();

        accounts.add(new BankAccount(id, username, balance));
        System.out.println("Successfully added!");
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
}