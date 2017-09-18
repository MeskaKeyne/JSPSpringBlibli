package be.ste.st.spring.blibli.modele;

import java.util.ArrayList;
import java.util.Date;
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
	public List<EBook> listerLivre(){
		
		List<EBook> ebook = new ArrayList<EBook>();
		for(LivreImpl book: this.dao.getAllLivres() ) {
			ebook.add(new EBook(book, this.dao.getReservationsByLivreCode(book.getCode())));
		}
		return ebook;
	}
	public List<CollectionImpl> listerCollection(){return this.dao.getAllCollections();}
	public void ajouterLivre(String titre, short nombreDePages, Date dateDeParution, int idCollection, short numeroEdition, List<Integer> auteurs) {this.dao.addLivre(titre, nombreDePages, dateDeParution, idCollection, numeroEdition, auteurs);}
	public List<AuteurImpl> listerAutheur(){return this.dao.getAllAuteurs();}
	public AuteurImpl addAuteur(String prenom, String nom) {return  this.dao.addAuteur(prenom, nom);}
	public void delAuteur(String id) {this.dao.removeAuteur(Integer.parseInt(id));}
	public CollectionImpl addCollection(String col_name) {return this.dao.addCollection(col_name);}
	public void delco(String id) {this.dao.removeCollection(Integer.parseInt(id));}	
	public boolean isBooked(String code){
		return !this.dao.getReservationsByLivreCode(code).isEmpty();
	}
	public void delBook(String code) {
		if(!this.isBooked(code)) this.dao.removeLivre(code);
	}
}
