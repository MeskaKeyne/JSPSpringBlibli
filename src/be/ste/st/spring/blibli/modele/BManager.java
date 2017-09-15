package be.ste.st.spring.blibli.modele;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	

}
