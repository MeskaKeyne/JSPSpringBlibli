package be.ste.st.spring.blibli.controleur;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import be.ste.st.spring.blibli.modele.BManager;
import be.steformations.pc.java_data.biblio.beans.AuteurImpl;

//@org.springframework.stereotype.Component  
@org.springframework.stereotype.Controller 
@org.springframework.context.annotation.Scope("request") 

public class Auteur {
	
	@org.springframework.beans.factory.annotation.Autowired
	protected BManager manager;
	
	public Auteur() {}
	@org.springframework.web.bind.annotation.RequestMapping("alist")
	public String getBookList(Map<String, Object> param) {
		List<AuteurImpl> liste = this.manager.listerAutheur(); 
		if(liste == null) liste = new ArrayList<AuteurImpl>();
		param.put("LISTE_AUTEUR",liste);
		return "/auteur.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("addAuteur")
	public String addAuteur(@org.springframework.web.bind.annotation.RequestParam("AUTEUR_PRENOM") 
							String prenom, @org.springframework.web.bind.annotation.RequestParam("AUTEUR_NOM") String nom, Map<String, Object> param) {
		if(!nom.matches("[A-Za-z]") || !prenom.matches("[A-Za-z]")) 
			param.put("OK", this.manager.addAuteur(prenom, nom));
		else param.put("OK", null);
		return this.getBookList(param);
		
	}
	@org.springframework.web.bind.annotation.RequestMapping("delAuteur")
	public String delAuteur(@org.springframework.web.bind.annotation.RequestParam("ID") String id, 
							@org.springframework.web.bind.annotation.RequestParam("DELETE") boolean del, 
							Map<String, Object> param ) {
		System.out.println("delAuteur");
		
		if(del && id.matches("^[0-9]*$")) this.manager.delAuteur(id);
		return this.getBookList(param);
		
	}
}
