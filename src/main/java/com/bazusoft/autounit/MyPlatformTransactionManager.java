package com.bazusoft.autounit;

import org.springframework.transaction.*;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * Created by BSaladra on 03.06.2017.
 */
public class MyPlatformTransactionManager implements PlatformTransactionManager {

    @Override
    public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
        if (transactionDefinition.getName() == null) {
            throw new NoTransactionException("Name cannot be empty");
        }
        return new DefaultTransactionStatus(null, false, false, false, false, null);
    }

    @Override
    public void commit(TransactionStatus transactionStatus) throws TransactionException {

    }

    @Override
    public void rollback(TransactionStatus transactionStatus) throws TransactionException {

    }
}
