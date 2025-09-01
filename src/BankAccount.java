class BankAccount {
    private String accountName;
    private double balance;
    private int PIN;

    BankAccount (String accountName, int PIN) {
        this.accountName = accountName;
        this.PIN = PIN;
        balance = 0;
    }

    public void checkBalance() {
        System.out.println("Current balance: £" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }  
    }

    public boolean verifyPIN(int inputPIN) {
        boolean valid = true;

        if (inputPIN == PIN) {
            System.out.println("PIN validated. Welcome to Java ATM.");
        } else {
            System.out.println("Invalid PIN");
            valid = false;
        }
        return valid;
    }
}