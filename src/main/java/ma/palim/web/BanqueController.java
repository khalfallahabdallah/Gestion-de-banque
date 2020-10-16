package ma.palim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ma.palim.entities.Compte;
import ma.palim.entities.Operation;
import ma.palim.metier.IBanqueMetier;

@Controller 
public class BanqueController { 
	@Autowired 
	private IBanqueMetier banqueMetier; 
	
	@RequestMapping("/operations") 
	public String index() { 
		return "operations"; 
	} 
	
	@RequestMapping(value = "/consulterCompte", method = RequestMethod.GET) 
	public String consulterCompte(Model model, String codeCompte,
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="4") int size) { 
		try { 
			Compte compte = banqueMetier.consulterCompte(codeCompte); 
			Page<Operation> pageOperations = banqueMetier .listOperation(codeCompte, page, size); 
			model.addAttribute("listeOperations", pageOperations .getContent()); 
			int [] pages = new int[pageOperations.getTotalPages()]; 
			model.addAttribute("pages", pages);
			model.addAttribute("compte", compte); 
		} catch (Exception e) { 
			model.addAttribute("exception", e); 
		} 
		return "comptes"; 
	}
	
	@RequestMapping(value = "/enregistrerOperation", method = RequestMethod.POST) 
	public String enregisterOperation(Model model, String typeOperation, String codeCompte, 
			double montant, String codeCompte2) {
		try { 
			if (typeOperation.equals("VERS")) {
				banqueMetier.verser(codeCompte, montant); 
			} 
			if (typeOperation.equals("RET")) { 
				banqueMetier.retirer(codeCompte, montant); 
			} 
			if (typeOperation.equals("VIR")) { 
				banqueMetier.virement(codeCompte, codeCompte2, montant); 
			} 
		} catch (Exception e) { 
			model.addAttribute("error", e); 
			return "redirect:consulterCompte?codeCompte=" +codeCompte+"&error="+e.getMessage(); 
		} 
		return "redirect:consulterCompte?codeCompte="+codeCompte;
	}
}
