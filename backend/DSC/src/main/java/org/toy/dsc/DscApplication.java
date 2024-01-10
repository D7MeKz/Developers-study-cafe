package org.toy.dsc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.toy.dsc.config.DbConfiguration;

@EnableJpaAuditing // Basetime을 위한 Auditing 기능 추가
@SpringBootApplication
public class DscApplication {

	private static final Logger log = LoggerFactory.getLogger(DscApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DscApplication.class, args);
		DbConfiguration dbConfiguration = applicationContext.getBean(DbConfiguration.class);
		log.info(dbConfiguration.toString());

	}

}
