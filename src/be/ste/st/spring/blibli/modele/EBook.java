package be.ste.st.spring.blibli.modele;

import java.util.Date;
import java.util.List;

import be.steformations.java_data.biblio.interfaces.Auteur;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.Livre;
import be.steformations.java_data.biblio.interfaces.Reservation;
import be.steformations.pc.java_data.biblio.beans.LivreImpl;
import be.steformations.pc.java_data.biblio.beans.ReservationImpl;

public class EBook implements Livre {
	private LivreImpl _livre;
	private List<ReservationImpl> _booked;

	public EBook(LivreImpl livre, List<ReservationImpl> list) {
		this._livre = livre;
		this._booked = list;
	}
	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return this._livre.getCode();
	}

	@Override
	public String getTitre() {
		// TODO Auto-generated method stub
		return this._livre.getTitre();
	}

	@Override
	public short getNombreDePages() {
		// TODO Auto-generated method stub
		return this._livre.getNombreDePages();
		
	}

	@Override
	public short getNumeroEdition() {
		// TODO Auto-generated method stub
		return this._livre.getNumeroEdition();
	}

	@Override
	public Date getDateDeParution() {
		// TODO Auto-generated method stub
		return this._livre.getDateDeParution();
	}

	@Override
	public Collection getCollection() {
		// TODO Auto-generated method stub
		return this._livre.getCollection();
	}

	@Override
	public List<? extends Auteur> getAuteurs() {
		// TODO Auto-generated method stub
		return this._livre.getAuteurs();
	}
	public List<ReservationImpl> getBooked() {
		return this._booked;
	}

}
