package service;

import pojo.MarginAccount;
import pojo.TradeAccount;
import repository.TradeAccountRepository;

import java.math.BigDecimal;

/**
 * Service class for handling operations on MarginAccount objects.
 */
public class MarginAccountService implements TradeAccountService {

    // Repository for storing and managing MarginAccount instances
    private TradeAccountRepository repository;

    /**
     * Constructor that injects the TradeAccountRepository dependency.
     * @param repository the shared TradeAccountRepository
     */
    public MarginAccountService(TradeAccountRepository repository) {
        this.repository = repository;
    }

    /**
     * Adds the specified amount to the MarginAccount's margin.
     * @param id account ID
     * @param amount amount to deposit
     */
    @Override
    public void deposit(String id, BigDecimal amount) {
        MarginAccount account = (MarginAccount) repository.retrieveTradeAccount(id);
        account.setMargin(account.getMargin().add(amount));
        repository.updateTradeAccount(account);
    }

    /**
     * Subtracts the specified amount from the MarginAccount's margin.
     * @param id account ID
     * @param amount amount to withdraw
     */
    @Override
    public void withdraw(String id, BigDecimal amount) {
        MarginAccount account = (MarginAccount) repository.retrieveTradeAccount(id);
        account.setMargin(account.getMargin().subtract(amount));
        repository.updateTradeAccount(account);
    }

    /**
     * Stores the given MarginAccount in the repository.
     * @param account the MarginAccount to store
     */
    public void createTradeAccount(MarginAccount account) {
        repository.createTradeAccount(account);
    }

    /**
     * Retrieves the MarginAccount with the specified ID.
     * @param id account ID
     * @return MarginAccount instance or null
     */
    public MarginAccount retrieveTradeAccount(String id) {
        return (MarginAccount) repository.retrieveTradeAccount(id);
    }

    /**
     * Updates the stored MarginAccount in the repository.
     * @param account updated MarginAccount
     */
    public void updateTradeAccount(MarginAccount account) {
        repository.updateTradeAccount(account);
    }

    /**
     * Deletes the MarginAccount with the specified ID from the repository.
     * @param id account ID
     */
    public void deleteTradeAccount(String id) {
        repository.deleteTradeAccount(id);
    }
}