package be.ste.st.spring.blibli.controleur;

public enum pages {
	BOOK("/book.jsp"),
	COLLECTION("/collection.jsp"),
	AUTEUR("/auteur.jsp");
	
	private String page="";
	pages(String page){this.page =page;}
	public String toString() {return this.page;}
}
