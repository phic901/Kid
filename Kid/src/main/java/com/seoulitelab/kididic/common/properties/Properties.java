package com.seoulitelab.kididic.common.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:repository-props.xml")
@PropertySource("classpath:database.properties")
public class Properties {

}
