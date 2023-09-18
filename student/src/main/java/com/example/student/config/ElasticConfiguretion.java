package com.example.student.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: ElasticConfiguretion
 * @date: 2023/7/12 下午4:38
 * @author: zcy
 * @version: 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticConfiguretion {

    private String host;

    private Integer port;

    @Bean
    public RestHighLevelClient client() {
        System.out.println(host);
        System.out.println(port);

        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host, port, "http")
                )
        );
    }

}
