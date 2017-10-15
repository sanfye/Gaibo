package com.gaibo.biz.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:spring/applicationContext.xml"})
public class DataSourcesConfiguration {

}
