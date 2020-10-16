package ma.palim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import ma.palim.dao.ClientRepository;
import ma.palim.dao.CompteRepository;
import ma.palim.dao.OperationRepository;
import ma.palim.entities.Client;
import ma.palim.entities.Compte;
import ma.palim.entities.CompteCourant;
import ma.palim.entities.CompteEpargne;
import ma.palim.entities.Retrait;
import ma.palim.entities.Versement;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Banque1Application  implements CommandLineRunner {
	
	  @Autowired private ClientRepository clientRepository;
	  
	  @Autowired private CompteRepository compteRepository;
	  
	  @Autowired private OperationRepository operationRepository;
	 

	public static void main(String[] args) {
		SpringApplication.run(Banque1Application.class, args);
}
	
	  @Override public void run(String... arg0) throws Exception { Client p1 =
	  clientRepository.save(new Client("Ahmed", "ahmed@mail.com"));
	  
	  Client p2 = clientRepository.save(new Client("Aicha", "aicha@mail.com"));
	  
	  Client p3 = clientRepository.save(new Client("Merieme", "merieme@mail.com"));
	  
	  Compte c1 = compteRepository.save(new CompteCourant("cp 1111", new Date(),
	  50000, p1, 1000));
	  
	  Compte c2 = compteRepository.save(new CompteEpargne("cp 2222", new Date(),
	  30000, p1, 5.5));
	  
	  Compte c3 = compteRepository.save(new CompteCourant("cp 3333", new Date(),
	  80000, p2, 1000));
	  
	  Compte c4 = compteRepository.save(new CompteCourant("cp 4444", new Date(),
	  50000, p3, 1000));
	  
	  operationRepository.save(new Versement(new Date(), 200, c1));
	  
	  operationRepository.save(new Retrait(new Date(), 4000, c2));
	  
	  operationRepository.save(new Versement(new Date(), 100, c3));
	  
	  operationRepository.save(new Retrait(new Date(), 3000, c4)); }
	 
}
