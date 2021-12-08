/**
 * 
 */
package com.nagarjuna.solr.audit.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Repository;

import com.nagarjuna.solr.audit.model.Audit;


@Repository
public class CustomSolrAuditRepository {
	
	@Resource
    private SolrTemplate solrTemplate;
	
    public List<Audit> dynamicSearch(String searchTerm) {
        Criteria conditions = createConditions(searchTerm);
        SimpleQuery search = new SimpleQuery(conditions);
         
        search.addSort(sortByIdDesc());
 
        Page<Audit> results = solrTemplate.queryForPage("Audit", search, Audit.class);
        return results.getContent();
    }
 
    private Criteria createConditions(String searchTerm) {
        Criteria conditions = null;
 
        for (String term: searchTerm.split(" ")) {
            if (conditions == null) {
                conditions = new Criteria("id").contains(term)
                        .or(new Criteria("sourcename").contains(term));
            }
            else {
                conditions = conditions.or(new Criteria("id").contains(term))
                        .or(new Criteria("sourcename").contains(term));
            }
        }
        return conditions;
    }
 
    private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }
    
}
