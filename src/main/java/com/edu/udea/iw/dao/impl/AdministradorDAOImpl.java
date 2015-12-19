package com.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edu.udea.iw.dao.AdministradorDAO;
import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.exception.MyException;

public class AdministradorDAOImpl extends HibernateDaoSupport implements AdministradorDAO {

	public List<Administrador> consultar() throws MyException {
		List<Administrador> administradores = new ArrayList<Administrador>();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Administrador.class);
			administradores = criteria.list();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return administradores;
	}

	public Administrador consultaUnica(String usuario) throws MyException {
		Administrador administrador = new Administrador();
		Session session = null;
		
		try {

			session = getSession();
			Criteria criteria = session.createCriteria(Administrador.class).add(Restrictions.eq("usuario", usuario));
			administrador = (Administrador) criteria.uniqueResult();

		} catch (HibernateException e) {

			throw new MyException(e);

		} 

		return administrador;
	}

	public Boolean guardar(Administrador administrador) throws MyException {
		boolean isSaved = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.save(administrador);
			isSaved = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isSaved;
	}

	public Boolean actualizar(Administrador administrador) throws MyException {
		boolean isUpdated = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.update(administrador);
			isUpdated = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isUpdated;
	}

	public Boolean eliminar(Administrador administrador) throws MyException {
		boolean isDeleted = false;
		Session session = null;
		Transaction tr = null;
		try {
			session = getSession();
			// Guarda el objeto
			// Inicia la transaccion
			tr = (Transaction) session.beginTransaction();
			session.delete(administrador);
			isDeleted = true;
			
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			
			
		
		}
		
		return isDeleted;
	}

}
