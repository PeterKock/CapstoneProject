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

    // More methods will be added in the next tasks
}
