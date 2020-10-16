package ma.palim.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation { 
	private static final long serialVersionUID = 1L; 
	public Versement() { } 
	public Versement(Date dateOperation, double montant, Compte compte) { 
		super(dateOperation, montant, compte); 
		} 
	}
