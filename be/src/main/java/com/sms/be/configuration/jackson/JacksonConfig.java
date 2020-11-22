package com.sms.be.configuration.jackson;


import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
    public class JacksonConfig {

        @Bean
        Module getHibernate5Module() {
            return new Hibernate5Module();
        }
    }

