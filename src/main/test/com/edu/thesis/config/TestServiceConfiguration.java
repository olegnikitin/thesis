package com.edu.thesis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Oleg on 12.04.2015.
 */
@Configuration
@Import({MvcConfiguration.class, AppSecurityConfig.class})
public class TestServiceConfiguration {
}
