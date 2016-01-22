package com.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.iw.dao.TipoGalaxiaDAO;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion utilizando hibernate de la interface {@link TipoGalaxiaDAO}
 * @author enhanced_universe
*/
public class TipoGalaxiaDAOImpl  extends HibernateDaoSupport implements TipoGalaxiaDAO {

	public List<TipoGalaxia> consultar() throws MyException {
		List<TipoGalaxia> tipogalaxias = new ArrayList<TipoGalaxia>();
		Session session = null;
		
		try {

			session =getSession();
			Criteria criteria = session.createCriteria(TipoGalaxia.class);
			tipogalaxias = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return tipogalaxias;
	}

	public Boolean guardar(TipoGalaxia tipogalaxia) throws MyException {
		
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(tipogalaxia);
			isSaved = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;

	}

	public Boolean eliminar(TipoGalaxia tipoGalaxia) throws MyException {
		boolean isDelete = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(tipoGalaxia);
			isDelete = true;
			tr.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDelete;
	}

}
