package org.example.config;

import org.example.Desktop;
import org.example.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
    Ths @ComponentScan will look for @Component annotation on all the classes being used. So
    You don't need any of the current things under AppConfig{....}

 */
@ComponentScan("org.example")
public class AppConfig {

    /*
    @Bean(name={"testBean"})
    This is how you specify bean name

    @Scope("prototype")
    Assigning scope like xml
     */
    @Bean
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean
    /*
    public Worker worker(@Qualifier("desktop") Computer com)....
    This will work like ref from xml allowing you to pass Interface objects
     */
    public Worker worker(){
        return new Worker();
    }

}
