package org.my.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by home on 2016-09-10.
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(
		useDefaultFilters = false
		, basePackages = {"org.my.board"}
		, includeFilters = @ComponentScan.Filter(value = {Service.class, Repository.class}, type = FilterType.ANNOTATION)
)
public class RootContextConfig {

}
