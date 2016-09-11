package org.my.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * Created by home on 2016-09-10.
 */
@EnableWebMvc
@EnableTransactionManagement
@Configuration
@ComponentScan(
        useDefaultFilters = false
        , basePackages = {"org.my.board"}
        , includeFilters = @ComponentScan.Filter(value = {Service.class, Repository.class, Component.class}, type = FilterType.ANNOTATION)
)
public class RootContextConfig {

}
