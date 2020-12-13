package za.co.iherridge0.databasedemo.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import za.co.iherridge0.databasedemo.databasedemo.entity.Person;
import za.co.iherridge0.databasedemo.databasedemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class DatabasedemoApplication implements CommandLineRunner{
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabasedemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("All users -> {}", dao.findAll());
		log.info("User id 10001 -> {}", dao.findById(10001));
		log.info("Deleting -> {}", dao.deleteById(10002));
		Person person = new Person(10004, "Irwin", "SA", new Date());
		log.info("Insert user -> {}", dao.insert(person));
		person.setLocation("Western Cape, SA");
		log.info("Update user -> {}", dao.update(person));
	}

}
