package ma.palim.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.palim.entities.Compte; 

 public interface CompteRepository extends JpaRepository<Compte, String> { }
