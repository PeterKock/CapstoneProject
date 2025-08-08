package pojo;

/**
 * The TradeAccount class serves as a base abstract class for different types of trading accounts.
 * It contains the common field 'id' and enforces subclasses to implement the clone() method.
 */
public abstract class TradeAccount {

    // Unique identifier for the trade account (e.g., A1234B)
    private String id;

    /**
     * Constructor to initialize the TradeAccount with a given ID.
     * @param id the account ID
     */
    public TradeAccount(String id) {
        this.id = id;
    }

    /**
     * Returns the ID of the trade account.
     * @return account ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the trade account.
     * @param id new account ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Abstract method that must be implemented by subclasses to return a copy of the account.
     * @return a cloned TradeAccount object
     */
    public abstract TradeAccount clone();
}
