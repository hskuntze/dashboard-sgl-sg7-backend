package br.mil.eb.dashboard_sgl_sg7.config.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
	basePackages = "br.mil.eb.dashboard_sgl_sg7.repositories.sgl",   // Pacote onde os repositórios JPA estão
    entityManagerFactoryRef = "entityManagerFactorySgl",   // Referência ao bean do EntityManagerFactory
    transactionManagerRef = "transactionManagerSgl"   // Referência ao bean do TransactionManager
)@EntityScan(basePackages = "br.mil.eb.dashboard_sgl_sg7.entities.sgl")
public class DBSglConfig {
	
    @Bean
    DataSource dataSourceSgl() {
    	HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sgl_dump_2");
        dataSource.setUsername("root");
        dataSource.setPassword("1q2w3e4rT%$#@!");
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
        
        // Definir explicitamente o provedor de persistência (Hibernate)
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factoryBean;
    }

    @Bean
    PlatformTransactionManager transactionManagerSgl(
        @Qualifier("entityManagerFactorySgl") EntityManagerFactory entityManagerFactorySgl) {
        
        return new JpaTransactionManager(entityManagerFactorySgl);
    }
}