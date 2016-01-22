package com.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dao.TipoGalaxiaDAO;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion utilizando hibernate de la interface {@link GalaxiaDAO}
 * @author enhanced_universe
*/
public class GalaxiaDAOImpl extends HibernateDaoSupport implements GalaxiaDAO {

	public List<Galaxia> consultar() throws MyException {
		List<Galaxia> galaxias = new ArrayList<Galaxia>();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Galaxia.class);
			galaxias = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return galaxias;
	}

	public Galaxia consultaUnica(String nombre) throws MyException {
		
		Galaxia galaxia = new Galaxia();
		
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Galaxia.class).add(Restrictions.eq("nombre", nombre));
			galaxia = (Galaxia) criteria.uniqueResult();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return galaxia;
	}

	public Boolean guardar(Galaxia galaxia) throws MyException {
		
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(galaxia);
			tr.commit();
			isSaved = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean actualizar(Galaxia galaxia) throws MyException {
		boolean isUpdated = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.update(galaxia);
			isUpdated = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isUpdated;
	}

	public Boolean eliminar(Galaxia galaxia) throws MyException {
		boolean isDeleted = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(galaxia);
			isDeleted = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDeleted;
	}

}
