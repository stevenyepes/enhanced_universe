package com.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.iw.dao.AsteroideDAO;
import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion utilizando hibernate de la interface {@link AsteroideDAO}
 * @author enhanced_universe
*/
public class AsteroideDAOImpl extends HibernateDaoSupport implements AsteroideDAO{

	public List<Asteroide> consultar() throws MyException {
		List<Asteroide> asteroides = new ArrayList<Asteroide>();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Asteroide.class);
			asteroides = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return asteroides;
	}

	public Asteroide consultaUnica(String nombre) throws MyException {
		Asteroide asteroide = new Asteroide();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Asteroide.class).add(Restrictions.eq("nombre", nombre));
			asteroide = (Asteroide) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new MyException(e);

		} 

		return asteroide;
	}

	public Boolean guardar(Asteroide asteroide) throws MyException {
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(asteroide);
			isSaved = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean actualizar(Asteroide asteroide) throws MyException {
		boolean isUpdated = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.update(asteroide);
			isUpdated = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isUpdated;
	}

	public Boolean eliminar(Asteroide asteroide) throws MyException {
		boolean isDeleted = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(asteroide);
			isDeleted = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDeleted;
	}

}
