/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.sessionbean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;
import org.primefaces.model.SortOrder;

import com.crm.entities.AEntity;
import com.crm.presentation.session.SessionUtils;

/**
 *
 * @author abuzo
 */
public abstract class AbstractFacade<T extends AEntity> {

	private Class<T> entityClass;

	private static final Logger LOG = LogManager.getLogger(AbstractFacade.class);

	@Inject
	private com.crm.presentation.session.UserManager userManager;

	public AbstractFacade(Class<T> entityClass) {

		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public void edit(T entity) {

		AEntity ent = entity;
		if (ent.getId() == null) {
			ent.setCreatedDate(new Date());
			ent.setModifiedDate(new Date());
			ent.setIsActive(true);
			ent.setUserCreated(userManager.getCurrentUser().getId());
			ent.setUserModified(userManager.getCurrentUser().getId());
			getEntityManager().merge(entity);
			LOG.info(getMessage(entity, "CREATE" + entity.toString(), "CREATE"));
		} else {
			ent.setUserModified(userManager.getCurrentUser().getId());
			ent.setModifiedDate(new Date());
			getEntityManager().merge(entity);
			LOG.info(getMessage(entity, "MODIFY " + entity.toString(), "MODIFY"));
		}
	}

	public void inactivate(T entity) {

		LOG.info(getMessage(entity, "INACTIVATE " + entity.toString(), "REMOVE"));
		entity.setModifiedDate(new Date());
		entity.setIsActive(false);
		getEntityManager().merge(entity);
	}

	public void remove(T entity) {

		LOG.info(getMessage(entity, "REMOVE " + entity.toString(), "INACTIVATE"));
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public void activate(T entity) {

		LOG.info(getMessage(entity, "ACTIVATE " + entity.toString(), "ACTIVATE"));
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	@TransactionAttribute
	public T find(Object id) {

		T t = getEntityManager().find(entityClass, id);
		LOG.info(getMessage(t, "READ " + t.toString(), "READ"));
		return t;
	}

	@TransactionAttribute
	public List<T> findAll() {

		javax.persistence.criteria.CriteriaQuery cq =
				getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	@TransactionAttribute
	public List<T> findAllActive() {

		return getEntityManager().createNativeQuery(
				"Select * from " + entityClass.getSimpleName() + " where isActive = 1", entityClass)
				.getResultList();
	}

	@TransactionAttribute
	public List<T> findRange(int[] range) {

		javax.persistence.criteria.CriteriaQuery cq =
				getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	@TransactionAttribute
	public int count() {

		javax.persistence.criteria.CriteriaQuery cq =
				getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

	private Predicate getFilterCondition(CriteriaBuilder cb, Root<T> myObj,
			Map<String, Object> filters) {

		Predicate filterCondition = cb.conjunction();
		String wildCard = "%";
		for (Map.Entry<String, Object> filter : filters.entrySet()) {
			String value = wildCard + filter.getValue() + wildCard;
			if (!filter.getValue().equals("")) {
				javax.persistence.criteria.Path<String> path = myObj.get(filter.getKey());
				filterCondition = cb.and(filterCondition, cb.like(path, value));
			}
		}
		return filterCondition;
	}

	@TransactionAttribute
	public int count(Map<String, Object> filters) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<T> myObj = cq.from(entityClass);
		cq.where(getFilterCondition(cb, myObj, filters));
		cq.select(cb.count(myObj));
		return getEntityManager().createQuery(cq).getSingleResult().intValue();
	}

	@TransactionAttribute
	public List<T> getResultList(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> myObj = cq.from(entityClass);
		cq.where(getFilterCondition(cb, myObj, filters));
		if (sortField != null) {
			if (sortOrder == SortOrder.ASCENDING) {
				cq.orderBy(cb.asc(myObj.get(sortField)));
			} else if (sortOrder == SortOrder.DESCENDING) {
				cq.orderBy(cb.desc(myObj.get(sortField)));
			}
		}
		return getEntityManager().createQuery(cq).setFirstResult(first).setMaxResults(pageSize)
				.getResultList();
	}

	private MapMessage getMessage(T entity, String message, String action) {

		MapMessage mapMessage = new MapMessage();
		mapMessage.put("username", SessionUtils.getUserNameFromContext());
		mapMessage.put("message", message);
		mapMessage.put("objecttype", entityClass.toString());
		mapMessage.put("action", action);
		mapMessage.put("appid", "FIRECRM");
		mapMessage.put("usersession", SessionUtils.getSession().getId());
		mapMessage.put("event", "EVENT");
		if (((AEntity) entity).getId() != null)
			mapMessage.put("objectid", ((AEntity) entity).getId().toString());
		return mapMessage;
	}

	/**
	 * @return the userManager
	 */
	public com.crm.presentation.session.UserManager getUserManager() {

		return userManager;
	}

	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(com.crm.presentation.session.UserManager userManager) {

		this.userManager = userManager;
	}
}
