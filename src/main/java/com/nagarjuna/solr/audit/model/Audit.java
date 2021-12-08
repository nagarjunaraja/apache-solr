/**
 * 
 */
package com.nagarjuna.solr.audit.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection="audit")
public class Audit {
    
    @Id
    @Indexed(name = "id", type = "long")
    private String auditId;
 
    @Indexed(name = "sourceid", type = "string")
    private String sourceId;
    
    @Indexed(name = "sourcename", type = "string")
    private String sourceName;
    
	@Indexed(name = "eventtype", type = "string")
    private String eventType;

    @Indexed(name = "tenantcode", type = "string")
    private String tenantCode;
    
    @Indexed(name = "createdby", type = "string")
    private String createdBy;

    @Indexed(name = "createdon", type = "date")
    private LocalDateTime createdOn;
    
    public String getAuditId() {
		return auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}


}
	
