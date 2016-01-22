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
import com.edu.udea.iw.dao.GlosarioDAO;
import com.edu.udea.iw.dto.Glosario;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion utilizando hibernate de la interface {@link GlosarioDAO}
 * @author enhanced_universe
*/
public class GlosarioDAOImpl extends HibernateDaoSupport implements GlosarioDAO{

	public List<Glosario> consultar() throws MyException {
		List<Glosario> glosarios = new ArrayList<Glosario>();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Glosario.class);
			glosarios = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return glosarios;
	}

	public Glosario consultaUnica(String termino) throws MyException {
		Glosario glosario = new Glosario();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Glosario.class).add(Restrictions.eq("termino", termino));
			glosario = (Glosario) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new MyException(e);

		} 

		return glosario;
	}

	public Boolean guardar(Glosario glosario) throws MyException {
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(glosario);
			isSaved = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean actualizar(Glosario glosario) throws MyException {
		boolean isUpdated = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.update(glosario);
			isUpdated = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isUpdated;
	}

	public Boolean eliminar(Glosario glosario) throws MyException {
		boolean isDeleted = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(glosario);
			isDeleted = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDeleted;
	}

}
