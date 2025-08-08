import pojo.CashAccount;
import pojo.MarginAccount;
import pojo.TradeAccount;
import repository.TradeAccountRepository;

import java.math.BigDecimal;

/**
 * Main class for testing repository CRUD operations on TradeAccount objects.
 */
public class Main {
    public static void main(String[] args) {

        // Create repository instance
        TradeAccountRepository repository = new TradeAccountRepository();

        // Create and store a CashAccount
        CashAccount cashAccount = new CashAccount("C123", new BigDecimal("1000.00"));
        repository.createTradeAccount(cashAccount);

        // Create and store a MarginAccount
        MarginAccount marginAccount = new MarginAccount("M456", new BigDecimal("5000.00"));
        repository.createTradeAccount(marginAccount);

        // Retrieve and display CashAccount
        TradeAccount retrievedCashAccount = repository.retrieveTradeAccount("C123");
        System.out.println("Retrieved Cash Account ID: " + retrievedCashAccount.getId());
        System.out.println("Cash Balance: " + ((CashAccount) retrievedCashAccount).getCashBalance());

        System.out.println();

        // Retrieve and display MarginAccount
        TradeAccount retrievedMarginAccount = repository.retrieveTradeAccount("M456");
        System.out.println("Retrieved Margin Account ID: " + retrievedMarginAccount.getId());
        System.out.println("Margin: " + ((MarginAccount) retrievedMarginAccount).getMargin());
    }
}