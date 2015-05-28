package com.scb.event.message.repository;

import com.scb.event.message.model.EventMessageAttribute;
import com.scb.event.message.model.id.EventMessageAttributeKey;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface MessageAttributeRepository extends
		GenericCrudRepository<EventMessageAttribute, EventMessageAttributeKey> {

}
