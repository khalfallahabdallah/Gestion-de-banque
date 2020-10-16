package ma.palim.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte { 
	private static final long serialVersionUID = 1L; 
	private double taux; 
	public CompteEpargne() { } 
	public CompteEpargne(String codeCompte, Date dateCreation, double solde, 
			Client client, double taux) { 
		super(codeCompte, dateCreation, solde, client); 
		this.taux = taux; 
		} // Getters/Setters + toString() }
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}