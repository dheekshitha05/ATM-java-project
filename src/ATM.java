import java.util.Scanner;

class ATM {
    public static Scanner s = new Scanner (System.in);

    public static void main (String[] args) {
        System.out.println("Enter your name: ");
        String name = s.nextLine();
     
        System.out.println("Choose a PIN: ");
        int PIN = Integer.parseInt(s.nextLine());

        BankAccount b = new BankAccount(name, PIN);

        int choice = 0;
        while (choice != 4) {
            displayMenu();
            choice = Integer.parseInt(s.nextLine());
            
            userMenu(choice, b);
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
        System.out.println("(4) Exit ATM");
        System.out.println("----------------------------");
    }
}