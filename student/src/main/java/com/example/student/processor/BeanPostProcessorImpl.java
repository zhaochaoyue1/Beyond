package com.example.student.processor;

import com.example.student.project.service.impl.Landlord;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Landlord){
            System.out.println("postProcessBeforeInitialization");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Landlord){
            System.out.println("postProcessAfterInitialization");
        }
        return null;
    }
}
