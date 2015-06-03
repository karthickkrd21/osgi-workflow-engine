package com.scb.event.message.repository;



import com.scb.event.message.model.EventMessageFork;
import com.scb.event.message.model.ExecutionStatus;
import com.scb.event.message.model.id.EventMessageForkKey;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface MessageForkRepository extends GenericCrudRepository<EventMessageFork, EventMessageForkKey> {

	public Iterable<EventMessageFork> findByExecutionStatus(ExecutionStatus executionStatus);
}
