package com.Tourism.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil class provides a utility to create and manage the Hibernate SessionFactory.
 */
public class HibernateUtil {

	// Static SessionFactory instance created once during application startup
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Builds the SessionFactory from hibernate.cfg.xml configuration file.
	 * 
	 * @return SessionFactory instance
	 */
	private static SessionFactory buildSessionFactory()
	{

		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch (Throwable ex) {
			// Log the exception and rethrow as an ExceptionInInitializerError
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Provides the globally accessible SessionFactory instance.
	 * 
	 * @return SessionFactory instance
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Closes caches and connection pools.
	 */
	public static void shutdown()
	{
		getSessionFactory().close();
	}
}