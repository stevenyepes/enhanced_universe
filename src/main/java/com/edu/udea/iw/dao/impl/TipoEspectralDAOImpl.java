package com.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dao.TipoEspectralDAO;
import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion utilizando hibernate de la interface {@link TipoEspectralDAO}
 * @author enhanced_universe
*/
public class TipoEspectralDAOImpl extends HibernateDaoSupport implements TipoEspectralDAO{

	public List<TipoEspectral> consultar() throws MyException {
		List<TipoEspectral> tipoEspectral = new ArrayList<TipoEspectral>();
		Session session = null;
		
		try {

			session =getSession();
			Criteria criteria = session.createCriteria(TipoEspectral.class);
			tipoEspectral = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return tipoEspectral;
	}

	public Boolean guardar(TipoEspectral tipoEspectral) throws MyException {
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(tipoEspectral);
			isSaved = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean eliminar(TipoEspectral tipoEspectral) throws MyException {
		boolean isDelete = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(tipoEspectral);
			isDelete = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDelete;
	}
	

}
