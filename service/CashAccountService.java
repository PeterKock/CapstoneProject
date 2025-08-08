package service;

import pojo.CashAccount;
import repository.TradeAccountRepository;

import java.math.BigDecimal;

/**
 * Service class for handling operations on CashAccount objects.
 */
public class CashAccountService implements TradeAccountService {

    // Repository for storing and managing CashAccount instances
    private TradeAccountRepository repository;

    /**
     * Constructor that injects the TradeAccountRepository dependency.
     * @param repository the shared TradeAccountRepository
     */
    public CashAccountService(TradeAccountRepository repository) {
        this.repository = repository;
    }

    /**
     * Adds the specified amount to the CashAccount's balance.
     * @param id account ID
     * @param amount amount to deposit
     */
    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount account = (CashAccount) repository.retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().add(amount));
        repository.updateTradeAccount(account);
    }

    /**
     * Subtracts the specified amount from the CashAccount's balance.
     * @param id account ID
     * @param amount amount to withdraw
     */
    @Override
    public void withdraw(String id, BigDecimal amount) {
        CashAccount account = (CashAccount) repository.retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().subtract(amount));
        repository.updateTradeAccount(account);
    }

    /**
     * Stores the given CashAccount in the repository.
     * @param account the CashAccount to store
     */
    public void createTradeAccount(CashAccount account) {
        repository.createTradeAccount(account);
    }

    /**
     * Retrieves the CashAccount with the specified ID.
     * @param id account ID
     * @return CashAccount instance or null
     */
    public CashAccount retrieveTradeAccount(String id) {
        return (CashAccount) repository.retrieveTradeAccount(id);
    }

    /**
     * Updates the stored CashAccount in the repository.
     * @param account updated CashAccount
     */
    public void updateTradeAccount(CashAccount account) {
        repository.updateTradeAccount(account);
    }

    /**
     * Deletes the CashAccount with the specified ID from the repository.
     * @param id account ID
     */
    public void deleteTradeAccount(String id) {
        repository.deleteTradeAccount(id);
    }
}