package be.ste.st.spring.blibli.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import be.ste.st.spring.blibli.modele.BManager;
import be.steformations.pc.java_data.biblio.beans.CollectionImpl;

@org.springframework.stereotype.Controller 
@org.springframework.context.annotation.Scope("request") 
public class Collection {
	
	@org.springframework.beans.factory.annotation.Autowired
	protected BManager manager;
	
	public Collection() {}
	@org.springframework.web.bind.annotation.RequestMapping("clist")
	public String getBookList(Map<String, Object> args) {
		List<CollectionImpl> liste = this.manager.listerCollection(); 
		if(liste == null) liste = new ArrayList<CollectionImpl>();
		args.put("LISTE_COLLECTION",liste);
		return pages.COLLECTION.toString();
	}
	@org.springframework.web.bind.annotation.RequestMapping("addCo")
	public String addAuteur(@org.springframework.web.bind.annotation.RequestParam("COL_NAME") String col_name,
							Map<String, Object> args) {
		
		if(!col_name.matches("[A-Za-z]"))  args.put("OK", this.manager.addCollection(col_name));
		else args.put("OK", null);
		return this.getBookList(args);	
	}
	@org.springframework.web.bind.annotation.RequestMapping("delco")
	public String delCo(@org.springframework.web.bind.annotation.RequestParam("ID") String id, 
							@org.springframework.web.bind.annotation.RequestParam("DELETE") boolean del,
							Map<String, Object> args) {
		
		if(del && !this.manager.isInCollection(Integer.parseInt(id))) this.manager.delco(id);
	
		return "/spring/clist";
		
	}

}
