import java.util.Scanner;
import java.util.HashMap;

class ATM {
    public static Scanner s = new Scanner (System.in);
    private static HashMap<String, BankAccount> accounts = new HashMap<>();

    public static void main (String[] args) {

        int choice1 = 0;
        while (choice1 != 3) {
            loginMenu();
            choice1 = Integer.parseInt(s.nextLine());

            BankAccount b = null;

            if (choice1 == 1) {
                b = createAccount();
            } else if (choice1 == 2) {
                b = login();
            }

            int choice2 = 0;

            if (b != null) {
                while (choice2 != 4) {
                    displayMenu();
                    choice2 = Integer.parseInt(s.nextLine());
                    userMenu(choice2, b);
                }
            }
        }
    }

    public static void userMenu(int choice, BankAccount b) {
        switch (choice) {
            case 1: 
                b.checkBalance();
                break;
            case 2:
                System.out.println("Enter amount: ");
                double amount = Double.parseDouble(s.nextLine());
                b.deposit(amount);
                break;
            case 3:
                System.out.println("Enter amount: ");
                amount = Double.parseDouble(s.nextLine());
                b.withdraw(amount);
                break;
        }
    }

    public static void displayMenu() {
        System.out.println("----------------------------");
        System.out.println("     Welcome to Java ATM    ");
        System.out.println("----------------------------");
        System.out.println("(1) Check Balance");
        System.out.println("(2) Deposit");
        System.out.println("(3) Withdraw");
        System.out.println("(4) Log out");
        System.out.println("----------------------------");
    }

    public static void loginMenu () {
        System.out.println("-----------------------------");
        System.out.println("     Welcome to Java ATM     ");
        System.out.println("-----------------------------");
        System.out.println("(1) Create new account");
        System.out.println("(2) Login to existing account");
        System.out.println("(3) Exit ATM");
        System.out.println("-----------------------------");
    }

    public static BankAccount createAccount() {
        BankAccount b;

        System.out.println("Enter name of account: ");
        String name = s.nextLine();

        if (accounts.containsKey(name)) {
            System.out.println("This account already exists.");
            b = accounts.get(name);
        }  else {
            System.out.println("Create a 4 digit PIN: ");
            int userPIN = Integer.parseInt(s.nextLine());

            b = new BankAccount(name, userPIN);
            accounts.put(name, b);
        }
        return b;
    }

    public static BankAccount login() {
        System.out.println("Enter name of account: ");
        String name = s.nextLine();

        if (accounts.containsKey(name)) {
            BankAccount b = accounts.get(name);

            boolean valid = false;
            for(int i = 0; i < 3; i++) {
                System.out.println("Enter your 4 digit PIN: ");
                int inputPIN = Integer.parseInt(s.nextLine());
                valid = b.verifyPIN(inputPIN);

                if (valid == true) {
                    return b;
                }
            }
            System.out.println("3 Incorrect attempts, try again later!");
            return null;
        } else {
            System.out.println("Account does not exist.");
            return null;
        }
    }
}