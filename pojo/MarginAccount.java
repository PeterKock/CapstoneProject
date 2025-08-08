package pojo;

import java.math.BigDecimal;

/**
 * Represents a margin-based trading account.
 * Inherits from TradeAccount and holds a margin balance.
 */
public class MarginAccount extends TradeAccount {

    // Margin balance available in the account
    private BigDecimal margin;

    /**
     * Constructor to initialize a MarginAccount with an ID and margin balance.
     * @param id the account ID
     * @param margin the margin amount
     */
    public MarginAccount(String id, BigDecimal margin) {
        super(id); // Call the constructor of TradeAccount
        this.margin = margin;
    }

    /**
     * Returns the current margin balance of the account.
     * @return margin balance
     */
    public BigDecimal getMargin() {
        return margin;
    }

    /**
     * Sets the margin balance of the account.
     * @param margin new margin balance
     */
    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    /**
     * Creates and returns a copy of this MarginAccount with the same ID and margin.
     * @return cloned MarginAccount object
     */
    @Override
    public MarginAccount clone() {
        return new MarginAccount(this.getId(), this.margin);
    }
}
