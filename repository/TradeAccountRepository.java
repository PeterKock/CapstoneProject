package repository;

import pojo.TradeAccount;
import java.util.HashMap;
import java.util.Map;

/**
 * Repository class for managing TradeAccount instances.
 * Provides CRUD operations backed by an in-memory data store.
 */
public class TradeAccountRepository {

    // In-memory store for trade accounts, keyed by account ID
    private Map<String, TradeAccount> datastore = new HashMap<>();

    /**
     * Stores a clone of the provided TradeAccount in the datastore.
     * @param account the TradeAccount to be stored
     */
    public void createTradeAccount(TradeAccount account) {
        this.datastore.put(account.getId(), account.clone());
    }

    /**
     * Retrieves a cloned TradeAccount from the datastore by its ID.
     * @param id the account ID
     * @return cloned TradeAccount if found, otherwise null
     */
    public TradeAccount retrieveTradeAccount(String id) {
        return this.datastore.get(id) == null ? null : this.datastore.get(id).clone();
    }
}