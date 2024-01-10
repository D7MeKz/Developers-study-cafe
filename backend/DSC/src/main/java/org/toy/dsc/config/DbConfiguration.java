package org.toy.dsc.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:dbConfig.properties")
public class DbConfiguration {

    // Environment 주입 맏으면 dbConfig에 지정된 설정을 읽을 수 있음.
    private final Environment env;

    public DbConfiguration(Environment env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "Username: " + env.getProperty("user") + " , Password : " + env.getProperty("password");
    }
}
