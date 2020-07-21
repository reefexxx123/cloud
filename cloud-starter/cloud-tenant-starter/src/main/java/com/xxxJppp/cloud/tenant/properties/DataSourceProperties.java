package com.xxxJppp.cloud.tenant.properties;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 *
 * @author 瑞夫
 * @version 1.0
 * @date 2020/7/20
 */
@Data
@Component
@ConfigurationProperties("spring.datasource")
public class DataSourceProperties {
	private String username;
	private String password;
	private String url;
	private String driverClassName;
	private HikariDataSource hikari;
}
