package be.ste.st.spring.blibli.controleur;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import be.ste.st.spring.blibli.modele.BManager;
import be.ste.st.spring.blibli.modele.EBook;
import be.steformations.pc.java_data.biblio.beans.AuteurImpl;
import be.steformations.pc.java_data.biblio.beans.CollectionImpl;
import be.steformations.pc.java_data.biblio.beans.LivreImpl;

//@org.springframework.stereotype.Component  
@org.springframework.stereotype.Controller 
@org.springframework.context.annotation.Scope("request") 

public class Book {
	
	@org.springframework.beans.factory.annotation.Autowired
	protected BManager manager;
	
	public Book() {}
	@org.springframework.web.bind.annotation.RequestMapping("booklist")
	public String getBookList(Map<String, Object> param) {
		List<EBook> liste = this.manager.listerLivre();
		List<CollectionImpl> collections = this.manager.listerCollection(); 
		List<AuteurImpl> auteurs = this.manager.listerAutheur(); 
		if(liste == null) liste = new ArrayList<EBook>();
		if(collections == null) collections = new ArrayList<CollectionImpl>();
		if(auteurs == null) auteurs = new ArrayList<AuteurImpl>();
		param.put("LISTE_LIVRE",liste);
		param.put("COLLECTION", collections);
		param.put("AUTEURS", auteurs);
		return pages.BOOK.toString();
	}
	@org.springframework.web.bind.annotation.RequestMapping("addbook")
	public String addBook(	@org.springframework.web.bind.annotation.RequestParam("TITRE") String titre,
							@org.springframework.web.bind.annotation.RequestParam("PAGES") String nombreDePages, 
							@org.springframework.web.bind.annotation.RequestParam("DATE") Date dateDeParution,
							@org.springframework.web.bind.annotation.RequestParam("ID_COLLECTION") String idCollection,
							@org.springframework.web.bind.annotation.RequestParam("ID_EDITION") String numeroEdition,
							@org.springframework.web.bind.annotation.RequestParam("AUTEUR") List<String> auteurs,
							Map<String, Object> param){
		
		
		List<Integer> auteur_id = new ArrayList<Integer>();
		if(!auteurs.isEmpty()) {
			for(String a : auteurs) auteur_id.add(Integer.parseInt(a));
		}
		this.manager.ajouterLivre(titre, Short.parseShort(nombreDePages), dateDeParution, Short.parseShort(idCollection), Short.parseShort(numeroEdition), auteur_id);
		return this.getBookList(param);
	}
	@org.springframework.web.bind.annotation.RequestMapping("delbook")
	public String delBook(@org.springframework.web.bind.annotation.RequestParam("ID") String id, 
							@org.springframework.web.bind.annotation.RequestParam("DELETE") boolean del,
							Map<String, Object> args) {
		
		if(del)this.manager.delBook(id);
		return this.getBookList(args);
		
	}

}
