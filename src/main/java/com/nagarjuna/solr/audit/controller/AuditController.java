/**
 * 
 */
package com.nagarjuna.solr.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarjuna.solr.audit.model.Audit;
import com.nagarjuna.solr.audit.repository.SolrAuditRepository;


@RestController
public class AuditController {
	
	@Autowired
	SolrAuditRepository solrAuditRepository;
	
	@PostMapping("/audit")
	public String createAudit(@RequestBody Audit audit){
		String description = "Audit Created";
		solrAuditRepository.save(audit);
		return description;
	}
	
	@GetMapping("/audit/{auditId}")
	public Audit readAudit(@PathVariable String auditId){
		return solrAuditRepository.findByAuditId(auditId);
	}
	
	@PutMapping("/audit")
	public String updateAudit(@RequestBody Audit audit){
		String description = "Audit Updated";
		solrAuditRepository.save(audit);
		return description;
	}
	
	@DeleteMapping("/audit/{auditId}")
	public String deleteAudit(@PathVariable String auditId){
		String description = "Audit Deleted";
		solrAuditRepository.delete(solrAuditRepository.findByAuditId(auditId));
		return description;
	}
	
	@GetMapping("/audit/eventtype/{eventType}/{page}")
	public List<Audit> findEventAudit(@PathVariable String eventType, @PathVariable int page){
		return solrAuditRepository.findByEventType(eventType, PageRequest.of(page, 2)).getContent();
	}
	
	@GetMapping("/audit/sourcename/{sourcename}/{page}")
	public List<Audit> findSourceAudit(@PathVariable String sourcename,@PathVariable int page){
		return solrAuditRepository.findBySourceName(sourcename, PageRequest.of(page, 2)).getContent();
	}
	

}
