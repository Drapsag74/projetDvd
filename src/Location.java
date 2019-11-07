

import java.util.Date;

public class Location {

	private int idLoc;
	private Date dateFin;
	private int nbProlongement;
	private Client client;

	public Location(int idLoc, Date dateFin, Client client) {
		super();
		this.idLoc = idLoc;
		this.dateFin = dateFin;
		this.nbProlongement = 0;
		this.client = client;
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
	
	
	
	

}
