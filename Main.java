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

    /**
     * Reads the transactions.txt file and applies each transaction to the correct account.
     * @throws IOException if the file read fails
     */
    public static void applyTransactions() throws IOException {
        // Open a buffered reader to read the transactions.txt file
        BufferedReader reader = Files.newBufferedReader(paths[1]);

        String line;
        // Read the file line-by-line
        while ((line = reader.readLine()) != null) {
            // Split each line into parts: [accountType, accountId, action, amount]
            String[] parts = line.split(" ");
            String type = parts[0];
            String id = parts[1];
            String action = parts[2];
            BigDecimal amount = new BigDecimal(parts[3]);

            // Process CASH accounts
            if (type.equals("CASH")) {
                if (action.equals("DEPOSIT")) {
                    cashAccountService.deposit(id, amount);
                } else if (action.equals("WITHDRAWAL")) {
                    cashAccountService.withdraw(id, amount);
                }

            // Process MARGIN accounts
            } else if (type.equals("MARGIN")) {
                if (action.equals("DEPOSIT")) {
                    marginAccountService.deposit(id, amount);
                } else if (action.equals("WITHDRAWAL")) {
                    marginAccountService.withdraw(id, amount);
                }
            }
        }

        // Close the reader
        reader.close();
    }

    /**
     * Retrieves and prints final balances of specified Cash and Margin accounts.
     * @throws IOException if account lookup fails
     */
    public static void finalTest() throws IOException {
        System.out.println("Account A1234B Cash Balance: " +
            cashAccountService.retrieveTradeAccount("A1234B").getCashBalance());

        System.out.println("Account E3456F Cash Balance: " +
            cashAccountService.retrieveTradeAccount("E3456F").getCashBalance());

        System.out.println("Account I5678J Cash Balance: " +
            cashAccountService.retrieveTradeAccount("I5678J").getCashBalance());

        System.out.println("Account C2345D Margin: " +
            marginAccountService.retrieveTradeAccount("C2345D").getMargin());

        System.out.println("Account G4567H Margin: " +
            marginAccountService.retrieveTradeAccount("G4567H").getMargin());
    }

        /**
     * Main method to execute the full flow: load accounts, apply transactions, and print final balances.
     */
    public static void main(String[] args) {
        try {
            loadTradeAccounts();
            applyTransactions();
            finalTest();
        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

}