package com.it.example.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class YamlPostProcessor implements BeanFactoryPostProcessor {

	private static final Log log = LogFactory.getLog(YamlPostProcessor.class);

	/**
	 * spring无法解析 yml 文件，通过此类实现扫描 classpath 目录下的全部 yml
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		try {
			YamlPropertiesFactoryBean yamlPropertiesFactoryBean;
			if (beanFactory.containsBean("yamlPropertiesFactoryBean")) {
				yamlPropertiesFactoryBean = beanFactory.getBean("yamlPropertiesFactoryBean", YamlPropertiesFactoryBean.class);
			} else {
				yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
				beanFactory.registerSingleton("yamlPropertiesFactoryBean", yamlPropertiesFactoryBean);
			}
			// 扫描classpath下的全部yml文件
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource[] resources = resolver.getResources("classpath*:**/*.yml");
			if (resources.length > 0) {
				ConfigurableEnvironment environment = beanFactory.getBean(ConfigurableEnvironment.class);
				MutablePropertySources sources = environment.getPropertySources();
				yamlPropertiesFactoryBean.setResources(resources);

				Properties properties = yamlPropertiesFactoryBean.getObject();
				if (properties != null) {
					sources.addFirst(new PropertiesPropertySource("yamlProperties", properties));
				}
			}
		} catch (Exception e) {
			log.error("扫描YML文件异常：", e);
		}
	}

}
