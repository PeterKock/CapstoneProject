import pojo.CashAccount;
import pojo.MarginAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Entry point for loading accounts, applying transactions, and printing final balances.
 */
public class Main {

    // File paths for account and transaction data
    static Path[] paths = new Path[]{
        Paths.get("data/accounts.txt"),
        Paths.get("data/transactions.txt")
    };

    // Shared repository and services for managing accounts
    static TradeAccountRepository tradeAccountRepository = new TradeAccountRepository();
    static CashAccountService cashAccountService = new CashAccountService(tradeAccountRepository);
    static MarginAccountService marginAccountService = new MarginAccountService(tradeAccountRepository);

    /**
     * Loads accounts from accounts.txt and adds them to the appropriate service.
     * @throws IOException if the file read fails
     */
    public static void loadTradeAccounts() throws IOException {
        // Open a buffered reader to read the accounts.txt file
        BufferedReader reader = Files.newBufferedReader(paths[0]);

        String line;
        // Read the file line-by-line
        while ((line = reader.readLine()) != null) {
            // Split each line into parts: [accountType, accountId, balance]
            String[] parts = line.split(" ");
            String type = parts[0];
            String id = parts[1];
            BigDecimal balance = new BigDecimal(parts[2]);

            // Create and store a CashAccount if the type is CASH
            if (type.equals("CASH")) {
                CashAccount cashAccount = new CashAccount(id, balance);
                cashAccountService.createTradeAccount(cashAccount);

            // Create and store a MarginAccount if the type is MARGIN
            } else if (type.equals("MARGIN")) {
                MarginAccount marginAccount = new MarginAccount(id, balance);
                marginAccountService.createTradeAccount(marginAccount);
            }
        }

        // Close the reader
        reader.close();
    }
}