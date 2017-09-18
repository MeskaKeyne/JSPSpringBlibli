package be.ste.st.spring.blibli.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import be.ste.st.spring.blibli.modele.BManager;
import be.steformations.pc.java_data.biblio.beans.CollectionImpl;

//@org.springframework.stereotype.Component  
@org.springframework.stereotype.Controller 
@org.springframework.context.annotation.Scope("request") 
public class Collection {
	
	@org.springframework.beans.factory.annotation.Autowired
	protected BManager manager;
	
	public Collection() {}
	
	@org.springframework.web.bind.annotation.RequestMapping("clist")
	public String getBookList(Map<String, Object> param) {
		List<CollectionImpl> liste = this.manager.listerCollection(); 
		if(liste == null) liste = new ArrayList<CollectionImpl>();
		param.put("LISTE_COLLECTION",liste);
		return "/collection.jsp";
	}
	

}
