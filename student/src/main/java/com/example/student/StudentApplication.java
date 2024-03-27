package com.example.student;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@ServletComponentScan
@EnableAspectJAutoProxy
public class StudentApplication {
    @Bean
    public SolrTemplate solrTemplate(SolrClient client) {
        return new SolrTemplate(client);
    }
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);

        //启动前增加系统参数
        /*new SpringApplicationBuilder(SbmlApplication.class)
                .listeners(new ApplicationListener<ApplicationEnvironmentPreparedEvent>() {
                    @Override
                    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
                        ConfigurableEnvironment environment = event.getEnvironment();
                        // 在这里添加自定义的属性源初始化逻辑
                        // 例如，可以添加额外的属性源或者自定义属性值
                        environment.getSystemProperties().put("testA", "custom value");
                    }
          }).run(args);*/
    }

    @Bean
    public String requiredPropertyCheck(Environment environment) {
        /**
         * 启动前检验是否缺少环境变配置
         */
        String requiredProperty = environment.getProperty("env_config");
        /*if (requiredProperty == null) {
            throw new IllegalStateException("Required property 'my.required.property' is not set");
        }*/
        return requiredProperty;
    }
}
