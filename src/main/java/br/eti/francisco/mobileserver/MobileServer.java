package br.eti.francisco.mobileserver;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.google.common.base.Predicate;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = {MobileServer.class})
public class MobileServer {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) throws Exception {
		SpringApplication.run(MobileServer.class, args);
	}


    @Autowired
    @Order(Ordered.HIGHEST_PRECEDENCE + 10)
    public void configureSimpleAuthUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN", "USER")
                .and().withUser("user").password("user").roles("USER");
    }
    
    
	
    @Order(1) 
    @Configuration
    public static class NoAuthConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
            http.csrf().disable();
        }
    }	
    
    @Bean
    public Docket allApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("All")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(true);
    }

    @Bean
    public Docket personApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Person")
                .apiInfo(apiInfo())
                .select()
                .paths(personPaths())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(true);
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    	em.setDataSource(dataSource);
    	em.setJpaVendorAdapter(jpaVendorAdapter());
    	em.setPackagesToScan("br.eti.francisco.mobileserver.model");
    	return em;
    }
    
    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter(){
    	HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    	jpaVendorAdapter.setShowSql(true);
    	jpaVendorAdapter.setGenerateDdl(true);
    	jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
    	return jpaVendorAdapter;
    }
    
    private Predicate<String> personPaths() {
        return PathSelectors.regex("/person.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springfox petstore API")
                .description("Spring Boot Angular example")
                .termsOfServiceUrl("http://springfox.io")
                .contact("springfox")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/chicocx/springboot-angular")
                .version("2.0")
                .build();
    }

}