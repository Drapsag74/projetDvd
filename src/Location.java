

import java.util.Date;

public class Location {
	private static int nbLoc=0;
	private int idLoc;
	private Date dateFin;
	private int nbProlongement;
	private Client client;
	private Dvd dvd;

	public Location(Date dateFin, Client client,Dvd d) {
		super();
		this.idLoc = nbLoc;
		incramente();
		this.dateFin = dateFin;
		this.nbProlongement = 0;
		this.client = client;
		this.dvd=d;
		this.client.paye(Film.PRIX);
	}
	
	public void deletLoc() {
		dvd.rendu();
		client.suppLoc(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (idLoc != other.idLoc)
			return false;
		return true;
	}
	
	private static void incramente() {
		nbLoc++;
	}
	
	public String toString() {
		return dvd.toString();
	}
	
	public Film getFilm() {
		return dvd.getFilm();
	}
	
	public void perte() {
		dvd.perte();
		client.suppLoc(this);
	}
	
	
	

}
