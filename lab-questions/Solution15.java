class Bank {
    static int account_number_generator = 10000;
    String name;
    int acc_no;
    float balance;

    Bank(String name, float min_deposit_amount) {
        this.name = name;
        this.acc_no = account_number_generator;
        this.balance = min_deposit_amount;     // Minimum amount required to open account!
             System.out.printf("\n\nHello %s, your account number is:  %d", name, acc_no);
        account_number_generator++;
    }

    void display() {
        System.out.println("\n\nWelcome " + name + ", to your account!");
        System.out.println("Account Number: " + acc_no);
        System.out.println("Current Balance: Rs." + balance);
    }

    void getBalance() {
        System.out.println("Your current balance:  Rs." + balance);
    }

    void withdraw(float amt) {
        if(balance <= amt || balance == 1000) {
            System.out.println("Sorry! you can't withdraw money!");
        }
        else {
            balance -= amt;
            System.out.println("\nAmount withdrawn:  Rs." + amt);
            getBalance();
        }
    }

    void deposit(float amt) {
        if(amt == 0.0) {
            System.out.println("Sorry! you can't deposit Rs. 0.0");
        }
        else {
            balance += amt;
            System.out.println("\nAmount deposited:  Rs." + amt);
            getBalance();
        }
    }
}


class Solution15 { 
    public static void main(String[] args) {
        Bank user1 = new Bank("John", 5055.5f);
        user1.display();
        user1.deposit(2550.5f);
        user1.withdraw(800);

        Bank user2 = new Bank("Emily", 2015.6f);
        user2.display();
        user2.deposit(1550.5f);
        user2.withdraw(500);
    }
}