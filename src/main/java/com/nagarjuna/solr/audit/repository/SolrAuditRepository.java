/**
 * 
 */
package com.nagarjuna.solr.audit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.nagarjuna.solr.audit.model.Audit;

public interface SolrAuditRepository extends SolrCrudRepository<Audit, String> {
	
	Audit findByAuditId(String auditId);
	
    @Query("eventtype:*?0*")
    Page<Audit> findByEventType(String searchTerm, Pageable pageable);
    
    @Query("sourcename:*?0*")
    Page<Audit> findBySourceName(String searchTerm, Pageable pageable);
    
}
