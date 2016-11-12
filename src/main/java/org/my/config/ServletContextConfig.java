package org.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

/**
 * Created by home on 2016-09-10.
 */
@Configuration
@EnableWebMvc
@ComponentScan(
        useDefaultFilters = false
        , basePackages = {"org.my.board", "org.my.study"}
        , includeFilters = {@ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION)})
public class ServletContextConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ViewResolver internalViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2);
        return viewResolver;
    }

    @Bean
    public ViewResolver scriptTemplateViewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/template/");
        viewResolver.setSuffix(".html");
        viewResolver.setViewNames("alert*");
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Bean
    public ScriptTemplateConfig scriptTemplateConfig() {
        ScriptTemplateConfigurer scriptTemplateConfigurer = new ScriptTemplateConfigurer();
        scriptTemplateConfigurer.setEngineName("nashorn");
        scriptTemplateConfigurer.setScripts("/WEB-INF/view/template/render.js");
        scriptTemplateConfigurer.setRenderFunction("render");
        return scriptTemplateConfigurer;
    }
}
