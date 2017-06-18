package com.adc.utils;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * 动态获取bean
 * @author Victor_Zhou
 *
 */
public class DynamicLoadBean implements ApplicationContextAware {  
	  
    private ConfigurableApplicationContext applicationContext = null;  
    public void setApplicationContext(ApplicationContext applicationContext)  
            throws BeansException {  
            this.applicationContext = (ConfigurableApplicationContext) applicationContext;  
    }  
  
    public ConfigurableApplicationContext getApplicationContext() {    
        return applicationContext;    
    }  
      
    /** 
     * 1.配置文件的位置固�? 
     * 2.配置文件中bean的名字已�? 
     * @param configLocationString 
     */  
     public void loadBean(String fileName)  
        {    
            XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry)getApplicationContext().getBeanFactory());    
            beanDefinitionReader.setResourceLoader(getApplicationContext());    
            beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(getApplicationContext()));    
            try  
            {    
                beanDefinitionReader.loadBeanDefinitions(getApplicationContext().getResources(fileName));    
            } catch (BeansException e) {    
                e.printStackTrace();    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
        }    
  
     public void registBean(String beanName, String parentName) {  
         DefaultListableBeanFactory  fcy = (DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();  
         BeanDefinition beanDefinition  = new ChildBeanDefinition(parentName);  
         fcy.registerBeanDefinition(beanName, beanDefinition);  
     }  
}  
