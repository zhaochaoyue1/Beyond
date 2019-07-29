package com.example.student;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;

@SpringBootApplication
//@ServletComponentScan
public class StudentApplication {
    @Bean
    public SolrTemplate solrTemplate(SolrClient client) {
        return new SolrTemplate(client);
    }
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

}
