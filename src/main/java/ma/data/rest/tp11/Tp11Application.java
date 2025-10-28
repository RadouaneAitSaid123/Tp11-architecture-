package ma.data.rest.tp11;

import ma.data.rest.tp11.beans.Client;
import ma.data.rest.tp11.beans.Compte;
import ma.data.rest.tp11.beans.TypeCompte;
import ma.data.rest.tp11.repositories.ClientRepository;
import ma.data.rest.tp11.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class Tp11Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp11Application.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration config) {
        return args -> {
            config.exposeIdsFor(Compte.class);

            Client client1 = clientRepository.save(new Client(null, "Radouane", "red@gmail.com", null));
            Client client2 = clientRepository.save(new Client(null, "Amal", "amal@gmail.com", null));

            compteRepository.save(new Compte(null, Math.random() * 4000, new Date(), TypeCompte.EPARGNE, client1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, client2));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, client2));

            compteRepository.findAll().forEach(compte -> {
                System.out.println(compte.toString());
            });
        };
    }

}
