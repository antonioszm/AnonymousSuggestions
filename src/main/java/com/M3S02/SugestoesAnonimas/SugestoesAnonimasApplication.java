package com.M3S02.SugestoesAnonimas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.M3S02.SugestoesAnonimas", "com.M3S02.SugestoesAnonimas.controller"})
public class  SugestoesAnonimasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SugestoesAnonimasApplication.class, args);
	}

}
