package com.cts.fasttack.core.config;

import com.cts.fasttack.core.liquibase.ExtendedSpringLiquibase;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * @author Anton Leliuk
 */
@Configuration
@EntityScan("com.cts.fasttack")
@EnableConfigurationProperties(LiquibaseProperties.class)
public class DatabaseConfig {

    @Autowired
    private Environment environment;

    @Autowired
    private LiquibaseProperties liquibaseProperties;

    @Primary
    @Bean
    public SessionFactory sessionFactory(EntityManagerFactory emf) {
        return emf.unwrap(SessionFactory.class);
    }


    @Bean(name = "h2SessionFactory")
    public LocalSessionFactoryBean h2SessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean h2SessionFactory = new LocalSessionFactoryBean();
        h2SessionFactory.setDataSource(h2DataSource());
        h2SessionFactory.setPackagesToScan("com.cts.fasttack");
        h2SessionFactory.setHibernateProperties(hibernateH2Properties());

        return h2SessionFactory;
    }

    @Bean(name="h2TransactionManager")
    public PlatformTransactionManager txManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(h2DataSource());
    }

    @Bean
    @Primary
    public SpringLiquibase liquibase(HikariDataSource dataSource){
        ExtendedSpringLiquibase liquibase = new ExtendedSpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(liquibaseProperties.getChangeLog());
        liquibase.setContexts(liquibaseProperties.getContexts());
        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
        liquibase.setShouldRun(liquibaseProperties.isEnabled());
        liquibase.setLabels(liquibaseProperties.getLabels());
        liquibase.setChangeLogParameters(liquibaseProperties.getParameters());
        liquibase.setRollbackFile(liquibaseProperties.getRollbackFile());
        return liquibase;
    }

    private DataSource h2DataSource() throws PropertyVetoException {
        HikariDataSource h2dataSource = new HikariDataSource();
        h2dataSource.setJdbcUrl(environment.getProperty("spring.h2.datasource.url"));
        h2dataSource.setDriverClassName(environment.getProperty("spring.h2.datasource.driver-class-name"));
        h2dataSource.setUsername(environment.getProperty("spring.h2.datasource.username"));
        h2dataSource.setPassword(environment.getProperty("spring.h2.datasource.password"));
        return h2dataSource;
    }

    private Properties hibernateH2Properties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "create");
        return properties;
    }
}
