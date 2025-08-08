package service;

import repository.TradeAccountRepository;

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

    @Override
    public void deposit(String id, java.math.BigDecimal amount) {
        
    }

    @Override
    public void withdraw(String id, java.math.BigDecimal amount) {
        
    }
}