package com.bazusoft.autounit;

import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by BSaladra on 01.05.2017.
 */
public class SolutionTest {


    MyPlatformHandler handler = new MyPlatformHandler(new MyPlatformTransactionManager());
    ProxyFactory proxyFactory = new ProxyFactory(handler);
    PlatformTransactionManager manager = proxyFactory.getObject();

    @Test
    public void getTransactionExceptionTest() {

        DefaultTransactionDefinition definition = new DefaultTransactionDefinition(0);
        try {
            manager.getTransaction(definition);
            fail();
        } catch (TransactionException e) {
        }

        assertEquals(0, handler.getTransaction.size());
    }

    @Test
    public void getTransactionSuccessTest() {

        DefaultTransactionDefinition definition = new DefaultTransactionDefinition(0);
        definition.setName("xid");
        try {
            manager.getTransaction(definition);
        } catch (TransactionException e) {
            fail();
        }

        assertEquals(1, handler.getTransaction.size());
        System.err.println(handler.getTransaction);
    }


}
