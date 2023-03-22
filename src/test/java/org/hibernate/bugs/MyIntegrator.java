package org.hibernate.bugs;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class MyIntegrator implements Integrator {

	@Override
	public void integrate(Metadata metadata, BootstrapContext bootstrapContext,
			SessionFactoryImplementor sessionFactory) {
		ServiceRegistry serviceRegistry = sessionFactory.getServiceRegistry();
		EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);
		listenerRegistry.getEventListenerGroup(EventType.PRE_LOAD).appendListener(new MyPreLoadEventListener());
	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
		// empty
	}

}
