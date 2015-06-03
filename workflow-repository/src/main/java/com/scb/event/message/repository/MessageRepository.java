package com.scb.event.message.repository;

import java.math.BigDecimal;

import com.scb.event.message.model.EventMessage;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface MessageRepository extends GenericCrudRepository<EventMessage, BigDecimal> {

}
