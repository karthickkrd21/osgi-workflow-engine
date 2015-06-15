package com.scb.event.workflow.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.event.message.model.EventMessageFork;

public class JacksonPayloadProcessor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private ObjectMapper objectMapper;

	public Object deserialize(final EventMessageFork messageFork) {
		try {
			objectMapper.readValue(messageFork.getEventMessage().getPayload(),
					Class.forName(messageFork.getEventMessage().getPayloadSubType()));
		} catch (final Exception e) {
			logger.info("JSON could not be parsed to Object", e);
		}
		return null;
	}

	public String serialize(final Object payload) {
		try {
			return objectMapper.writeValueAsString(payload);
		} catch (final Exception e) {
			logger.error("Payload could not be serialized as String", e);
		}
		return null;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(final ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

}