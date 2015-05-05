package org.arquillian.container.proxy;

import org.jboss.arquillian.container.spi.client.container.DeployableContainer;
import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveProcessor;
import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

public class ProxyExtension implements LoadableExtension {

    @Override
    public void register(ExtensionBuilder builder) {
        builder.service(DeployableContainer.class, ProxyDeployableContainer.class);
        builder.observer(ProxySetupObserver.class);
        builder.service(AuxiliaryArchiveProcessor.class, ArquillianProxyAppender.class);
    }

    public static class ArquillianProxyAppender implements AuxiliaryArchiveProcessor {
        @Override
        public void process(Archive<?> auxiliaryArchive) {
            if ("arquillian-core.jar".equals(auxiliaryArchive.getName())) {
                ((JavaArchive) auxiliaryArchive).addClass(ArquillianProxy.class);
            }
        }
    }

}
