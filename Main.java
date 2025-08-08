import pojo.CashAccount;
import pojo.MarginAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;

import java.math.BigDecimal;

/**
 * Main class to test CashAccountService and MarginAccountService logic.
 */
public class Main {
    public static void main(String[] args) {

        // Initialize repository and services
        TradeAccountRepository repository = new TradeAccountRepository();
        CashAccountService cashAccountService = new CashAccountService(repository);
        MarginAccountService marginAccountService = new MarginAccountService(repository);

        // Create and store accounts
        CashAccount cashAccount = new CashAccount("1", BigDecimal.valueOf(1000));
        MarginAccount marginAccount = new MarginAccount("2", BigDecimal.valueOf(2000));
        cashAccountService.createTradeAccount(cashAccount);
        marginAccountService.createTradeAccount(marginAccount);

        // Perform transactions
        cashAccountService.deposit("1", BigDecimal.valueOf(500));     // 1000 + 500 = 1500
        cashAccountService.withdraw("1", BigDecimal.valueOf(200));    // 1500 - 200 = 1300

        marginAccountService.deposit("2", BigDecimal.valueOf(1000));  // 2000 + 1000 = 3000
        marginAccountService.withdraw("2", BigDecimal.valueOf(500));  // 3000 - 500 = 2500

        // Retrieve and display updated account balances
        CashAccount updatedCashAccount = cashAccountService.retrieveTradeAccount("1");
        MarginAccount updatedMarginAccount = marginAccountService.retrieveTradeAccount("2");

        System.out.println("Updated CashAccount balance: " + updatedCashAccount.getCashBalance());
        System.out.println("Updated MarginAccount margin: " + updatedMarginAccount.getMargin());

        // Delete accounts
        cashAccountService.deleteTradeAccount("1");
        marginAccountService.deleteTradeAccount("2");
    }
}