package com.shades.greeter;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableEurekaClient
public class GreeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreeterApplication.class, args);
	}

}

@RestController
class GreeterService {
    private static Logger logger = (Logger)LoggerFactory.getLogger(GreeterService.class);
    @GetMapping("/greetings/{language}")
    public String greet(@PathVariable String language) {
        switch(language.toLowerCase()) {
            case "english": 
                return "Hello!";
            case "german": 
                return "Hallo";
            case "spanish": 
                return "hola";
            case "hindi":
                return "namaste";
            default:
                return "Hello";
        }
    }
    
    @PostMapping("/handleCompressed")
    public void handleCompressed(@RequestBody String body) {
        logger.info("Received compressed body ===========> \n {}", body);
    }
}