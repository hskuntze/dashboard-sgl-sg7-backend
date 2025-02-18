package br.mil.eb.dashboard_sgl_sg7.config.db;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "br.mil.eb.dashboard_sgl_sg7.repositories.sgl",   // Pacote onde os repositórios JPA estão
    entityManagerFactoryRef = "entityManagerFactorySgl",   // Referência ao bean do EntityManagerFactory
    transactionManagerRef = "transactionManagerSgl"   // Referência ao bean do TransactionManager
)
@EntityScan(basePackages = "br.mil.eb.dashboard_sgl_sg7.entities.sgl")
public class DBSglConfig {
	
	@Value("${spring.datasource.sgl.url}")
    private String dbUrl;

    @Value("${spring.datasource.sgl.username}")
    private String dbUser;

    @Value("${spring.datasource.sgl.password}")
    private String dbPassword;
	
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.sgl")
    DataSource dataSourceSgl() {
    	HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactorySgl(
        @Qualifier("dataSourceSgl") DataSource dataSourceSgl) {
        
    	LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSourceSgl);
        factoryBean.setPackagesToScan("br.mil.eb.dashboard_sgl_sg7.entities.sgl");   // Pacote onde as entidades JPA do banco 2 estão
        factoryBean.setPersistenceUnitName("sgl");   // Nome da unidade de persistência para o banco 'sgl'
        factoryBean.setJpaPropertyMap(jpaProperties());
        
        // Definir explicitamente o provedor de persistência (Hibernate)
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factoryBean;
    }

    @Bean
    PlatformTransactionManager transactionManagerSgl(
        @Qualifier("entityManagerFactorySgl") EntityManagerFactory entityManagerFactorySgl) {
        
        return new JpaTransactionManager(entityManagerFactorySgl);
    }
    
    private Map<String, Object> jpaProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.jdbc.lob.non_contextual_creation", true);
        return properties;
    }
}