package com.helloworld.salaries.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.helloworld.salaries.mappers")
public class MyBatisConfiguration {
}
