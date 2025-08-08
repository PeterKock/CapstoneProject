package service;

import repository.TradeAccountRepository;

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

    @Override
    public void deposit(String id, java.math.BigDecimal amount) {
        
    }

    @Override
    public void withdraw(String id, java.math.BigDecimal amount) {
        
    }
}