package ma.palim.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation { 
	private static final long serialVersionUID = 1L; 
	public Retrait() { } 
	public Retrait(Date dateOperation, double montant, Compte compte) { 
		super(dateOperation, montant, compte); 
		} 
	}