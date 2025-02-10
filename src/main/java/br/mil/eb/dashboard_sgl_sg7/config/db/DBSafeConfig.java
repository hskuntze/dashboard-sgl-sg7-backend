package br.mil.eb.dashboard_sgl_sg7.config.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "br.mil.eb.dashboard_sgl_sg7.repositories.safe",   // Pacote onde os repositórios JPA estão
    entityManagerFactoryRef = "entityManagerFactorySafe",   // Referência ao bean do EntityManagerFactory
    transactionManagerRef = "transactionManagerSafe"   // Referência ao bean do TransactionManager
)
@EntityScan(basePackages = "br.mil.eb.dashboard_sgl_sg7.entities.safe")
public class DBSafeConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.safe")
    DataSource dataSourceSafe() {
    	HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/safe");
        dataSource.setUsername("root");
        dataSource.setPassword("1q2w3e4rT%$#@!");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactorySafe(
        @Qualifier("dataSourceSafe") DataSource dataSourceSafe) {
        
    	LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSourceSafe);
        factoryBean.setPackagesToScan("br.mil.eb.dashboard_sgl_sg7.entities.safe");
        factoryBean.setPersistenceUnitName("safe");
        
        // Definir explicitamente o provedor de persistência (Hibernate)
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factoryBean;
    }

    @Bean
    PlatformTransactionManager transactionManagerSafe(
        @Qualifier("entityManagerFactorySafe") EntityManagerFactory entityManagerFactorySafe) {
        
        return new JpaTransactionManager(entityManagerFactorySafe);
    }
}