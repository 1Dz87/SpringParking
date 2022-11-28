package by.itstep.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class SpringCommonConfig {

    @Bean
    public Random random() {
        Random r = new Random();
        r.setSeed(999);
        return r;
    }
}
