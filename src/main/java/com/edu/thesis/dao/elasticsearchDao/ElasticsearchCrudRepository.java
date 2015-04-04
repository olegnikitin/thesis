package com.edu.thesis.dao.elasticsearchDao;

import com.edu.thesis.domain.Issue;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Oleg on 02.04.2015.
 */
public interface ElasticsearchCrudRepository<T, ID extends Integer> extends ElasticsearchRepository<Issue, Integer> {
    //TODO: Extend PagingAndSortingRepository<T, ID> if it is necessary
    //https://github.com/spring-projects/spring-data-elasticsearch
    //http://www.elastic.co/guide/en/elasticsearch/client/java-api/current/get.html
}
