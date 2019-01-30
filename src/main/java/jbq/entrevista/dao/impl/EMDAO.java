package jbq.entrevista.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jbq.entrevista.dao.DAOBase;


@Transactional(propagation=Propagation.REQUIRED)
public abstract class EMDAO<T> implements DAOBase<T> {	
	
	@Autowired	@PersistenceContext
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager(){
		return entityManager;
	}
	
	private void setEntityManager(EntityManager entityManager){
		entityManager = entityManager;
	}
	
	protected abstract Class getClazz();
	
	public void persistir(T objeto) {
		getEntityManager().merge(objeto);
		getEntityManager().flush();
	}
	
	
	public void excluir(T objeto) {
		getEntityManager().remove(objeto);
	}
	
	
	public List<T> list(int offset, int max){
		List<T> result = (List<T>) getEntityManager()
				 .createQuery("from "+getClazz().getName(), getClazz())
				 .setFirstResult(offset)
				 .setMaxResults(max)
				 .getResultList();
		
		return (result != null ? result : new ArrayList<T>());
	}
	
	public List<T> list(String campoBanco, String valorCampo) throws Exception {
		return (List<T>) getEntityManager()
						.createQuery("from "+getClazz().getName()+" where "+campoBanco+"="+valorCampo)
						.getResultList();
	}
	
	
	public List<T> listAll(){
		return (List<T>) getEntityManager()
							.createQuery("from "+getClazz().getName())
							.getResultList(); 
	}
	
	public T get(Long id) {
		return (T) getEntityManager().getReference(getClazz(), id);
	}	
}

