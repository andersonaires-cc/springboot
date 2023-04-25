package br.com.first.system.Config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
    
    @Bean
    public DataSource getDataSourceH2(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.username("sa");
        builder.password("sa");
        builder.url("jdbc:h2:mem:testdb");

        return builder.build();
    }
}
