package ma.palim.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.palim.entities.Client; 
 
public interface ClientRepository extends JpaRepository<Client, Long> { }
