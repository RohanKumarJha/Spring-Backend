package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		
		Alien object1 = context.getBean(Alien.class);
		object1.setId(101);
		object1.setName("Rishabh");
		object1.setTech("AI");
		
		Alien object2 = context.getBean(Alien.class);
		object2.setId(102);
		object2.setName("Rohan");
		object2.setTech("ML");
		
		AlienDB db = context.getBean(AlienDB.class);
		db.saveToDb(object1);
		db.saveToDb(object2);
		System.out.println(db.getAll());
	}

}
