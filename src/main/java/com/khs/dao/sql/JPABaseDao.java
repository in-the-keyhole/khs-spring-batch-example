package com.khs.dao.sql;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JPABaseDao<T, ID> {

	@javax.persistence.Transient
	@javax.persistence.PersistenceContext(name = "dataFactory", unitName = "data")
	protected javax.persistence.EntityManager entityManager;

	@Transactional(readOnly = true)
	public Long count(Class<T> clazz) {
		return (Long) entityManager.createQuery("select count(o) from " + clazz.getName() + " o").getSingleResult();
	}

	public Query createQuery(String query) {
		return entityManager.createQuery(query);
	}

	@Transactional(readOnly = true)
	public T find(Class<T> clazz, ID id, String... eagerPaths) {
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> find(String query) throws RuntimeException {
		// String queryString = "from " + type.getName() + " " + query;
		Query queryObject = entityManager.createQuery(query);
		return queryObject.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll(Class<T> clazz, String... eagerPaths) {
		String queryString = "from " + clazz.getName();
		Query queryObject = entityManager.createQuery(queryString);
		return queryObject.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findEntries(Class<T> clazz, int firstResult, int maxResults) {
		return entityManager.createQuery("select o from " + clazz.getName() + " o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	@Transactional
	public T merge(T entity) {
		T merged = entityManager.merge(entity);
		entityManager.flush();
		return merged;
	}

	@Transactional
	public T persist(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Transactional
	public void remove(Class<T> clazz, ID id, T entity) {
		if (!entityManager.contains(entity)) {
			entity = entityManager.find(clazz, id);
		}
		entityManager.remove(entity);
	}
}
