package com.ibm.msreskill.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.msreskill.audit.model.AuditEvent;

public interface AuditEventRepository extends JpaRepository<AuditEvent, String>{

}
