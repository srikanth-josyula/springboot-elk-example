package com.sample.elk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElkStackApplication {

	Logger logger=LoggerFactory.getLogger(ElkStackApplication.class);

	public static void main(String[] args) {
        SpringApplication.run(ElkStackApplication.class, args);
    }

}
