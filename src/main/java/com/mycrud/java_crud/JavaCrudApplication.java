package com.mycrud.java_crud;

import com.mycrud.java_crud.model.Usuario;
import com.mycrud.java_crud.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCrudApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UsuarioRepository rep){
        return args -> {
            rep.save(new Usuario("Cliff", 19, "997339090", "Masculino"));
            rep.save(new Usuario("Mary", 22, "99933333", "Feminino"));
            rep.save(new Usuario("Karen", 25, "98911111", "Feminino"));
            rep.save(new Usuario("Kai", 27, "999945645", "Masculino"));
        };
    }

}
