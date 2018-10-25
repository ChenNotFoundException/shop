package com.shop.util.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate????????????Session
 * @author Li Yongqiang
 */
public class HibernateUtils {
	// ????SessionFactory????
	private static SessionFactory factory = null;
	// ?????ThreadLocal????
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	// ?????Configuration????
	private static Configuration cfg = new Configuration();
	// ?????
	static {
		try {
			// ????Hibernate???????
			cfg.configure();
			// ?????SessionFactory
			factory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace(); // ????????
		}
	}
	/**
	 * ???Session????
	 * @return Session????
	 */
	public static Session getSession() {
		// ??threadLocal?л??Session
		Session session = (Session) threadLocal.get();
		// ?ж?session???????δ?????????
		if (session == null || !session.isOpen()) {
			if (factory == null) {
				rebuildSessionFactory();
			}
			// ??factory???????Session
			session = (factory != null) ? factory.openSession() : null;
			threadLocal.set(session); // ??session????threadLocal??
		}
		return session;
	}
	/**
	 * ???SessionFactory????
	 * @return SessionFactory????
	 */
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	/**
	 * ???Session
	 * @param session????
	 */
	public static void closeSession() {
		// ??threadLocal?л??Session
		Session session = (Session) threadLocal.get();
		// ???threadLocal?е????
		threadLocal.remove();
		if (session != null) {
			if (session.isOpen()) {
				session.close(); // ???Session
			}
		}
	}
	/**
	 * ????SessionFactory????
	 */
	public static void rebuildSessionFactory() {
		try {
			// ????Hibernate???????
			cfg.configure();
			// ?????SessionFactory
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace(); // ????????
		}
	}
}
