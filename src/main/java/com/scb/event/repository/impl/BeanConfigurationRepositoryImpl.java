package com.scb.event.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.collections.CollectionUtils;

import com.scb.event.model.EventBean;
import com.scb.event.repository.BeanConfigurationRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class BeanConfigurationRepositoryImpl extends GenericCrudRepositoryImpl<EventBean, String> implements
		BeanConfigurationRepository {

	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EventBean findByBeanClass(final String beanClass) {
		System.out.println("Inside find By Bean Class of Bean Configuration");
		final TypedQuery<EventBean> query = entityManager.createNamedQuery(EventBean.EVENT_BEAN_FIND_BY_BEAN_CLASS,
				EventBean.class);
		query.setParameter("beanClass", beanClass);
		final List<EventBean> eventBeans = query.getResultList();
		if (CollectionUtils.isNotEmpty(eventBeans)) {
			return eventBeans.get(0);
		}
		return null;
	}

	public void init() {
		System.out.println("Inside the init method of Bean Configuration Repository");
		final EventBean eventBean1 = findByBeanClass("com.scb.onewb.sp.dealpipeline.model.DealPipelineEntity");
		System.out.println("Event Bean: Bean Class: " + eventBean1.getBeanClass() + " Bean Id: " + eventBean1.getId());
	}

}
