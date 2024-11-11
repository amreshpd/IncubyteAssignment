package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.Addition;

@SpringBootApplication
public class IncubyteAssignmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(IncubyteAssignmentApplication.class, args);
	Addition add = ctx.getBean(Addition.class);
	System.out.println(add.add(""));
	System.out.println(add.add("1"));
	}

}
