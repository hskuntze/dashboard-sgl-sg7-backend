package br.mil.eb.dashboard_sgl_sg7.config.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
	basePackages = "br.mil.eb.dashboard_sgl_sg7.repositories.sg7",   // Pacote onde os repositórios JPA estão
    entityManagerFactoryRef = "entityManagerFactorySg7",   // Referência ao bean do EntityManagerFactory
    transactionManagerRef = "transactionManagerSg7"   // Referência ao bean do TransactionManager
)
@EntityScan(basePackages = "br.mil.eb.dashboard_sgl_sg7.entities.sg7")
public class DBSg7Config {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DBSg7Config.class);

	@Bean
	@Primary
	DataSource dataSourceSg7() {
	    HikariDataSource dataSource = new HikariDataSource();
	    dataSource.setJdbcUrl("jdbc:mysql://10.134.0.96:3306/sg7"); // Usar jdbc:mariadb://
	    dataSource.setUsername("dev");
	    dataSource.setPassword("Falcao3030!");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

	    // Testando a conexão ao banco de dados
	    try (Connection connection = dataSource.getConnection()) {
	        LOGGER.info("Conexão com o banco de dados 'sg7' estabelecida com sucesso!");
	        listDatabases(connection);
	    } catch (SQLException e) {
	        LOGGER.error("Falha ao estabelecer conexão com o banco de dados 'sg7'", e);
	    }

	    return dataSource;
	}
	
	private void listDatabases(Connection connection) {
        String sql = "SHOW DATABASES";
        try (Statement statement = connection.createStatement(); 
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            LOGGER.info("Listando bases de dados:");
            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                LOGGER.info("Banco de dados: " + databaseName);
            }
        } catch (SQLException e) {
            LOGGER.error("Erro ao listar as bases de dados", e);
        }
    }

	@Bean
	@Primary
	LocalContainerEntityManagerFactoryBean entityManagerFactorySg7(
	    @Qualifier("dataSourceSg7") DataSource dataSourceSg7) {
	    
	    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
	    factoryBean.setDataSource(dataSourceSg7);
	    factoryBean.setPackagesToScan("br.mil.eb.dashboard_sgl_sg7.entities.sg7");
	    factoryBean.setPersistenceUnitName("sg7");
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    factoryBean.setJpaVendorAdapter(vendorAdapter);

	    return factoryBean;
	}

    @Bean
	@Primary
    PlatformTransactionManager transactionManagerSg7(
        @Qualifier("entityManagerFactorySg7") EntityManagerFactory entityManagerFactorySg7) {
        
        return new JpaTransactionManager(entityManagerFactorySg7);
    }
}