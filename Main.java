import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;

import java.nio.file.Path;
import java.nio.file.Paths;

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
    
}