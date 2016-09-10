package org.my.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by home on 2016-09-10.
 */
@Configuration
@ComponentScan(
        useDefaultFilters = false
        , basePackages = {"org.my.board"}
        , includeFilters = {@ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION)})
public class ServletContextConfig {
}
