package bureau.services;

import bureau.repository.TransactionManager;

public abstract class BaseService {
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    protected TransactionManager getTransactionManager() {
        return transactionManager;
    }
}
