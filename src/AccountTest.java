import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {  public AccountTest() {
}

    public static void main(String[] args) {
        Account account1 = new Account(100211, "noveen", 3187.15);
        Account account2 = new Account(100221, "Mirza", 1999.0);
        Account account3 = new Account(100032, "Kayleigh", 3320.23);
        Account account4 = new Account(100032, "Rodgers", 9520.52);
        ArrayList<Transaction> transactions = new ArrayList();
        transactions.add(new Transaction(account1, "deposit", 198.28));
        transactions.add(new Transaction(account2, "withdraw", 23914.89));
        transactions.add(new Transaction(account3, "deposit", 300.05));
        transactions.add(new Transaction(account4, "withdraw", 790.89));
        transactions.add(new Transaction(account1, "deposit", 10.5));
        transactions.add(new Transaction(account2, "withdraw", 29.55));
        transactions.add(new Transaction(account3, "deposit", 549.89));
        transactions.add(new Transaction(account4, "withdraw", 7000.98));
        ExecutorService executorService = Executors.newCachedThreadPool();
        Iterator<Transaction> money = transactions.iterator();

        while(money.hasNext()) {
            Transaction transaction = (Transaction)money.next();
            executorService.execute(transaction);
        }

        executorService.shutdown();

        while(!executorService.isTerminated()) {
        }

    }
}


