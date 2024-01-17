package com.floppy.SpringbootRestfulwebservicesdemo;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot WebServices",
                description = "Spring boot Restful webService Documentation",
                contact = @Contact(
                        name = "Dinesh",
                        email = "dineshasd333@gmail.com",
                        url = "https://github.com/Dinesh333s"
                ),
                license = @License(
                        name = "Apache",
                        url = "https://github.com/Dinesh333s")
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring boot user Management",
                url = "https://github.com/Dinesh333s"
        )
)
public class SpringbootRestfulWebservicesDemoApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulWebservicesDemoApplication.class, args);
    }

}
