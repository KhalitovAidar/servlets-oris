package com.semestr1.utils;

import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseUtil {
    private static JdbcTemplate jdbcTemplate = null;

    public static JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            synchronized (DatabaseUtil.class) {
                if (jdbcTemplate == null) {
                    jdbcTemplate = createConnection();
                }
            }
        }
        return jdbcTemplate;
    }

    public static JdbcTemplate createConnection() {
        JdbcTemplate jdbcTemplate = null;
        try {
            Yaml yaml = new Yaml();
            try (InputStream inputStream = DatabaseUtil.class.getClassLoader().getResourceAsStream("properties.yml")) {
                Map<String, Map<String, String>> yamlMap = yaml.load(inputStream);
                Map<String, String> databaseProps = yamlMap.get("database");

                String url = databaseProps.get("url");
                String username = databaseProps.get("username");
                String password = databaseProps.get("password");
                String driver = databaseProps.get("driverClassName");

                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setDriverClassName(driver);
                dataSource.setUrl(url);
                dataSource.setUsername(username);
                dataSource.setPassword(password);

                jdbcTemplate = new JdbcTemplate(dataSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jdbcTemplate;
    }
}