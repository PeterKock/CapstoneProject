package service;

import java.math.BigDecimal;

/**
 * Interface for deposit and withdrawal operations on trade accounts.
 */
public interface TradeAccountService {

    /**
     * Deposits the specified amount into the account with the given ID.
     * @param id account ID
     * @param amount amount to deposit
     */
    void deposit(String id, BigDecimal amount);

    /**
     * Withdraws the specified amount from the account with the given ID.
     * @param id account ID
     * @param amount amount to withdraw
     */
    void withdraw(String id, BigDecimal amount);
}
