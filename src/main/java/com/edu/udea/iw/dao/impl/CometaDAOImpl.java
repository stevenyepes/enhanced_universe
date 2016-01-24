package com.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.iw.dao.CometaDAO;
import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion utilizando hibernate de la interface {@link Cometa}
 * @author enhanced_universe
*/
public class CometaDAOImpl extends HibernateDaoSupport implements CometaDAO {

	public List<Cometa> consultar() throws MyException {
		List<Cometa> cometas = new ArrayList<Cometa>();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Cometa.class);
			cometas = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return cometas;
	}

	public Cometa consultaUnica(String nombre) throws MyException {
		Cometa cometa = new Cometa();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Cometa.class).add(Restrictions.eq("nombre", nombre));
			cometa = (Cometa) criteria.uniqueResult();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return cometa;
	}

	public Boolean guardar(Cometa cometa) throws MyException {
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(cometa);
			isSaved = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean actualizar(Cometa cometa) throws MyException {
		boolean isUpdated = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.update(cometa);
			isUpdated = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isUpdated;
	}

	public Boolean eliminar(Cometa cometa) throws MyException {
		boolean isDeleted = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(cometa);
			isDeleted = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDeleted;
	}

}
