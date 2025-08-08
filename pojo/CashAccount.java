package pojo;

import java.math.BigDecimal;

/**
 * Represents a cash-based trading account.
 * Inherits from TradeAccount and holds a cash balance.
 */
public class CashAccount extends TradeAccount {

    // Current cash balance of the account
    private BigDecimal cashBalance;

    /**
     * Constructor to initialize a CashAccount with an ID and a cash balance.
     * @param id the account ID
     * @param cashBalance the initial cash balance
     */
    public CashAccount(String id, BigDecimal cashBalance) {
        super(id); // Call the constructor of TradeAccount
        this.cashBalance = cashBalance;
    }

    /**
     * Returns the current cash balance of the account.
     * @return cash balance
     */
    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    /**
     * Sets the cash balance of the account.
     * @param cashBalance new cash balance
     */
    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    /**
     * Creates and returns a copy of this CashAccount with the same ID and balance.
     * @return cloned CashAccount object
     */
    @Override
    public CashAccount clone() {
        return new CashAccount(this.getId(), this.cashBalance);
    }
}
