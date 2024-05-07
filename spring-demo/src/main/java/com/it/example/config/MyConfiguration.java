package com.it.example.config;

import com.it.example.bean.DbProperties;
import com.it.example.bean.MyBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Import({MyBeanA.class, DbProperties.class})
@ImportResource("classpath:spring-demo.xml")		// 仅支持 XML 和 *.groovy 等文件的解析
@PropertySource(encoding = "UTF-8",
		value = "classpath:db.properties")			// spring 不支持 yml 文件解析，springboot 可以
@Configuration
public class MyConfiguration {

	@Autowired
	DbProperties dbProperties;

	@Override
	public String toString() {
		return "MyConfiguration{" +
				"dbProperties=" + dbProperties +
				'}';
	}
}
