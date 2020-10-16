package ma.palim.metier;

import org.springframework.data.domain.Page;
import ma.palim.entities.Compte;
import ma.palim.entities.Operation; 
 
public interface IBanqueMetier { 

	public Compte consulterCompte(String codeCompte); 
	 public void verser(String codeCompte, double montant); 
	 public void retirer(String codeCompte, double montant); 
	 public void virement(String cs, String cd, double montant); 
	 public Page<Operation> listOperation(String codeCompte, int page, int size);
}
