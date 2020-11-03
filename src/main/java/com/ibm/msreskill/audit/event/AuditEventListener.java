 package com.ibm.msreskill.audit.event;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ibm.msreskill.audit.model.AuditEvent;
import com.ibm.msreskill.audit.repository.AuditEventRepository;
import com.ibm.msreskill.audit.stream.AuditStream;

@Component
public class AuditEventListener {
	@Autowired
	AuditEventRepository repo;
	private static Logger log = LoggerFactory.getLogger(AuditEventListener.class);

	@StreamListener(AuditStream.INPUT)
	public void handleAudit(@Payload String auditPayload) {

		log.info("Received =" + auditPayload);
		AuditEvent event = new AuditEvent(UUID.randomUUID().toString(), auditPayload,new Date());
		repo.save(event);
	}
}
