package com.bazusoft.autounit;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by BSaladra on 03.06.2017.
 */
public class MyPlatformHandler implements InvocationHandler {

    public HashMap<TransactionDefinition, TransactionStatus> getTransaction = new HashMap<>();
    private Object original;

    public MyPlatformHandler(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        try {
            if (method.getName().equals("getTransaction")) {
                return handleGetTransaction(original, method, args);
            }

            return method.invoke(original, method, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    private Object handleGetTransaction(Object proxy, Method method, Object[] args)
            throws InvocationTargetException, IllegalAccessException {

        TransactionDefinition def = (TransactionDefinition) args[0];
        TransactionStatus returnValue = (TransactionStatus) method.invoke(proxy, args);
        getTransaction.put(def, returnValue);
        return returnValue;
    }
}