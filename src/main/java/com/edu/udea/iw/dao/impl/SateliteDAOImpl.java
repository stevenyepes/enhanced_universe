package com.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.iw.dao.SateliteDAO;
import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.dto.Satelite;
import com.edu.udea.iw.exception.MyException;

public class SateliteDAOImpl extends HibernateDaoSupport implements SateliteDAO {

	public List<Satelite> consultar() throws MyException {
		List<Satelite> satelites = new ArrayList<Satelite>();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Satelite.class);
			satelites = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return satelites;
	}

	public Satelite consultaUnica(String nombre) throws MyException {
		Satelite satelite = new Satelite();
		
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Satelite.class).add(Restrictions.eq("nombre", nombre));
			satelite = (Satelite) criteria.uniqueResult();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return satelite;
	}

	public Boolean guardar(Satelite satelite) throws MyException {
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(satelite);
			isSaved = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean actualizar(Satelite satelite) throws MyException {
		boolean isUpdated = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.update(satelite);
			isUpdated = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isUpdated;
	}

	public Boolean eliminar(Satelite satelite) throws MyException {
		boolean isDeleted = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(satelite);
			isDeleted = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDeleted;
	}

}
