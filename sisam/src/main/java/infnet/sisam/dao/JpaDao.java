package infnet.sisam.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public abstract class JpaDao<T> implements Dao<T> {

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("rawtypes")
	private Class clazz;

	@SuppressWarnings("rawtypes")
	public JpaDao(Class clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public void salvar(T entity) {
		em.persist(entity);
	}

	@Override
	public void atualizar(T entity) {
		em.merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T buscar(Integer id) {
		return (T) em.find(clazz, id);
	}

	@Override
	public void excluir(T entity) {
		em.remove(entity);
	}
	
}
