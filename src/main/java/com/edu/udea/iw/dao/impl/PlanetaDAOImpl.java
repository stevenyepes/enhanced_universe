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
import com.edu.udea.iw.dao.PlanetaDAO;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementación utilizando hibernate de la interface {@link PlanetaDAO}
 * @author enhanced_universe
*/
public class PlanetaDAOImpl  extends HibernateDaoSupport implements PlanetaDAO {

	public List<Planeta> consultar() throws MyException {
		List<Planeta> planetas = new ArrayList<Planeta>();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Planeta.class);
			planetas = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return planetas;
	}

	public Planeta consultaUnica(String nombre) throws MyException {
		Planeta planeta = new Planeta();
		
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Planeta.class).add(Restrictions.eq("nombre", nombre));
			planeta = (Planeta) criteria.uniqueResult();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return planeta;
	}

	public Boolean guardar(Planeta planeta) throws MyException {
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(planeta);
			isSaved = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean actualizar(Planeta planeta) throws MyException {
		boolean isUpdated = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.update(planeta);
			isUpdated = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isUpdated;
	}

	public Boolean eliminar(Planeta planeta) throws MyException {
		boolean isDeleted = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(planeta);
			isDeleted = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDeleted;
	}

}
