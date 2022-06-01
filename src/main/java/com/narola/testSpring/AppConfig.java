package com.narola.testSpring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DevConfig.class,ProdConfig.class})
public class AppConfig {


}
