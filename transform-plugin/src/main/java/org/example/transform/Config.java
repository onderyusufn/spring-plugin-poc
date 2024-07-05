package org.example.transform;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }
}
