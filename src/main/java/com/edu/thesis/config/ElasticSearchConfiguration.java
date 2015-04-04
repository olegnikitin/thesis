package com.edu.thesis.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import static org.elasticsearch.node.NodeBuilder.*;

/**
 * Created by Oleg on 02.04.2015.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages="com.edu.thesis.dao.elasticsearchDao")
public class ElasticSearchConfiguration {

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        Node node = nodeBuilder().clusterName("thesis").node();
        Client client = node.client();
        ElasticsearchTemplate elasticsearchTemplate = new ElasticsearchTemplate(client);
        return elasticsearchTemplate;
    }

}
