package be.ste.st.spring.blibli.modele;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import be.steformations.pc.java_data.biblio.beans.AuteurImpl;
import be.steformations.pc.java_data.biblio.beans.CollectionImpl;
import be.steformations.pc.java_data.biblio.beans.LivreImpl;
import be.steformations.pc.java_data.biblio.dao.jpa.JpaGestionnaireBibliotheque;


@org.springframework.stereotype.Service
@org.springframework.context.annotation.Scope("application") 

public class BManager {

	
	protected EntityManager em;
	protected JpaGestionnaireBibliotheque dao ;
	
	public BManager() {
		this.em = Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
		this.dao = new JpaGestionnaireBibliotheque(em);
		
		System.out.println("init.manager");
	}
	public List<LivreImpl> listerLivre() {
		return this.dao.getAllLivres();
	}
	public List<CollectionImpl> listerCollection(){
		return this.dao.getAllCollections();
	}
	public List<AuteurImpl> listerAutheur(){
		return this.dao.getAllAuteurs();
	}
	public AuteurImpl addAuteur(String prenom, String nom) {
		return  this.dao.addAuteur(prenom, nom);

	}
	public void delAuteur(String id) {
		this.dao.removeAuteur(Integer.parseInt(id));
	}
	

}
