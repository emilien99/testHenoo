package com.example.springboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void createDataBase() {
		try
		{
			//étape 1: charger la classe driver
			Class.forName("com.mysql.jdbc.Driver");

			//étape 2: créer l'objet de connexion
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql?", "root", "");

			//étape 3: créer l'objet statement
			Statement stmt = conn.createStatement();

			//étape 4: exécuter la requéte
			System.out.println("Création de base de données...");
			stmt.executeUpdate("CREATE TABLE Utilisateurs(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, mail VARCHAR(100) NOT NULL, mdp VARCHAR(20) NOT NULL, admin INT DEFAULT 0)");
			stmt.executeUpdate("CREATE TABLE Produits (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, nom VARCHAR(50) NOT NULL, prix FLOAT, id_propriétaire INT, création DATE)");
			System.out.println("Bases de données crées avec succés...");

			//étape 5: fermez l'objet de connexion
			conn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		createDataBase();
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
