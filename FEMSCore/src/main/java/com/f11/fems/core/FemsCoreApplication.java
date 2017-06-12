package com.f11.fems.core;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.f11.fems.core.entity.Owner;
import com.f11.fems.core.si.OwnerService;

@SpringBootApplication
public class FemsCoreApplication implements CommandLineRunner {


	    @Autowired
	    DataSource dataSource;

	    @Autowired
	    OwnerService customerRepository;

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(FemsCoreApplication.class, args);
	    }

	    @Transactional(readOnly = true)
	    @Override
	    public void run(String... args) throws Exception {

	        System.out.println("DATASOURCE = " + dataSource);
/*
	        System.out.println("\n1.findAll()...");
	        for (Owner customer : customerRepository.findAll()) {
	            System.out.println(customer);
	        }	     */
	        
	        Owner owner = new Owner();
	        owner.setName("Test");
	        owner.setEmail("email");
	        owner.setPhone("1234");
	        customerRepository.save(owner);

	        System.out.println("Done!");

	    }
}
