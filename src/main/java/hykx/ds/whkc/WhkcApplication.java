package hykx.ds.whkc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(value = {"hykx.ds.whkc.rabbitmq"})
@EnableScheduling
public class WhkcApplication {
    public static void main(String[] args) {
        SpringApplication.run(WhkcApplication.class, args);
    }
}
