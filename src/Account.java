public class Account {
    private double balance;
    private String clientName;
    private int accountNum;


    public Account(int accountNum, String clientName, double balance) {
        this.accountNum =accountNum;
        this.clientName = clientName;
        this.balance = balance;
    }

    // Deposit and withdraw operations.
    // Synchronize the operations to allow thread synchronization
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("************************************************************************" +
                "\nGreetings " + clientName +
                "---------------------------------------------------------------------------------------" +
                "\nA deposit in the amount of $" + amount + " was made in the account number " + accountNum +
                ".\nThe new balance is $" + balance +
                "\n----------------------------------------------------------------------------\n\n");
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("********************************************************************************8" +
                    "\nGreetings " +  clientName +
                    "\n------------------------------------------------------------------------------------------------" +
                    "\nA withdrawal in the amount of $" + amount + " was made in the account number " + accountNum +
                    ".\nThe new balance is $" + balance +
                    "\n----------------------------------------------------------------------------\n\n");
        } else {
            System.out.println("**********************************************************************************************" +
                    "\nGreetings " + clientName +
                    "\n*********************************************************************************************" +
                    "\nInsufficient balance."+
                    "\nA withdrawal in the amount of $" + amount + " cannot be  completed." +
                    "\nThe balance of account number " + accountNum +" is $" + balance+
                    "\nBe careful with your expenses." +
                    "\n----------------------------------------------------------------------------\n\n");
        }
    }
}
