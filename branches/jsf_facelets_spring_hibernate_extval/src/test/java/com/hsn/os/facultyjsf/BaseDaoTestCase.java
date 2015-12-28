package com.hsn.os.facultyjsf;

import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public abstract class BaseDaoTestCase extends AbstractTransactionalDataSourceSpringContextTests {

	protected static HibernateTemplate hibernateTemplate;

	public BaseDaoTestCase() {
		setDependencyCheck(false);
		setAutowireMode(AUTOWIRE_BY_NAME);
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] {"classpath:/spring/applicationContext.xml"};
	}

	@Override
	protected ConfigurableApplicationContext loadContextLocations(
			String[] locations) throws Exception {
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(locations);
		initializeHibernateTemplate(appCtx);
		return appCtx;
	}

	private void initializeHibernateTemplate(ClassPathXmlApplicationContext appCtx) {
		if (hibernateTemplate == null) {
			SessionFactory sessionFactory = (SessionFactory) appCtx.getBean("sessionFactory");
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
	}
}
