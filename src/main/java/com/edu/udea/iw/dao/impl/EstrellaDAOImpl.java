package com.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.iw.dao.EstrellaDAO;
import com.edu.udea.iw.dto.Estrella;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion utilizando hibernate de la interface {@link EstrellaDAO}
 * @author enhanced_universe
*/
public class EstrellaDAOImpl extends HibernateDaoSupport implements EstrellaDAO{

	public List<Estrella> consultar() throws MyException {
		List<Estrella> estrellas = new ArrayList<Estrella>();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Estrella.class);
			estrellas = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return estrellas;
	}

	public Estrella consultaUnica(String nombre) throws MyException {
		Estrella estrella = new Estrella();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Estrella.class).add(Restrictions.eq("nombre", nombre));
			estrella = (Estrella) criteria.uniqueResult();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return estrella;
	}

	public Boolean guardar(Estrella estrella) throws MyException {
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(estrella);
			isSaved = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean actualizar(Estrella estrella) throws MyException {
		boolean isUpdated = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.update(estrella);
			isUpdated = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isUpdated;
	}

	public Boolean eliminar(Estrella estrella) throws MyException {
		boolean isDeleted = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(estrella);
			isDeleted = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDeleted;
	}

}
