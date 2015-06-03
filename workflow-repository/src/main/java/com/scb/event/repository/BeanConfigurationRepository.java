package com.scb.event.repository;



import com.scb.event.model.EventBean;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface BeanConfigurationRepository extends GenericCrudRepository<EventBean, String> {

	/*@Cacheable("eventBean")*/
	public EventBean findByBeanClass(String beanClass);
}
