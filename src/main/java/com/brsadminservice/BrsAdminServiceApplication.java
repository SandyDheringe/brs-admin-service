package com.brsadminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BrsAdminServiceApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BrsAdminServiceApplication.class, args);

        new SpringApplicationBuilder()
                .profiles("prod")
                .sources(BrsAdminServiceApplication.class)
                .run(args);
    }

}
