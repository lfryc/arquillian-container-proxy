package org.arquillian.container.proxy;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runners.model.InitializationError;

public class ArquillianProxy extends Arquillian {

    static {
        System.setProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager");
    }

    public ArquillianProxy(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
