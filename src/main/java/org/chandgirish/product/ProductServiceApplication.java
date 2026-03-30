package org.chandgirish.product;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) {
//        Dotenv dotenv = Dotenv.load();
//        System.out.println("THE PORT IS : " + dotenv.get("PORT"));
//        System.setProperty("PORT", dotenv.get("PORT"));

        Dotenv.configure().ignoreIfMissing().load(); // loads all .env variables
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}