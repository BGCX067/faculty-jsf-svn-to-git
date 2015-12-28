package com.hsn.os.facultyjsf;

/**
 * @author hturksoy
 */
public class HibernateConnectionTest extends BaseDaoTestCase  {

	public void testSample() {
		assertTrue(hibernateTemplate.getSessionFactory() != null);
	}

	/*
	public static void main(String[] args) {
		Session session = null;

		try {
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure("hibernate/config/hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			// Create new instance of Contact and set values in it by reading
			// them from form object
			System.out.println("Inserting Record");
			Course course = new Course();
			course.setCode("CD-001");
			course.setName("Calculus");
			session.save(course);
			tx.commit();
			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Actual course insertion will happen at this step
			session.flush();
			session.close();

		}

	}
	*/
}
