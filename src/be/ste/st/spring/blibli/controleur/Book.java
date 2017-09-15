package be.ste.st.spring.blibli.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import be.ste.st.spring.blibli.modele.BManager;
import be.steformations.pc.java_data.biblio.beans.LivreImpl;

//@org.springframework.stereotype.Component  
@org.springframework.stereotype.Controller 
@org.springframework.context.annotation.Scope("request") 

public class Book {
	
	@org.springframework.beans.factory.annotation.Autowired
	protected BManager manager;
	
	public Book() {}
	@org.springframework.web.bind.annotation.RequestMapping("list")
	public String getListe(Map<String, Object> param) {
		List<LivreImpl > liste = this.manager.listerLivre(); 
		if(liste == null) liste = new ArrayList<LivreImpl>();
		param.put("LISTE_LIVRE",liste);
		return "/book.jsp";
	}

}
