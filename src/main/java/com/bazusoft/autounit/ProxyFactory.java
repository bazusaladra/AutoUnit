package com.bazusoft.autounit;


import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by BSaladra on 03.06.2017.
 */
public class ProxyFactory {

    private final MyPlatformHandler handler;

    public ProxyFactory(MyPlatformHandler handler) {
        this.handler = handler;
    }

    public PlatformTransactionManager getObject() {

        PlatformTransactionManager proxy = (PlatformTransactionManager) Proxy.newProxyInstance(
                PlatformTransactionManager.class.getClassLoader(),
                new Class[] {PlatformTransactionManager.class},
                handler
        );

        return proxy;

    }

}
