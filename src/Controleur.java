import java.util.ArrayList;
import java.util.List;


public class Controleur {

	private List<Client> listClients;
	private List<Film> listFilms;
	
	public Controleur() {
		listClients= new ArrayList<>();
		listFilms = new ArrayList<>();
	}
	
	/**
	 * Reçoit en paramettre un client et une location. Supprime la location du client
	 * @param client
	 * Un objet Client
	 * @param location
	 * Un objet Location
	 */
	public void deletLoc(Client client, Location location) {
		client.suppLoc(location);
	}
	
	/**
	 * Reçoit en paramettre un client et un location. Ajoute la location au client
	 * @param client
	 * @param location
	 */
	public void louer(Client client, Location location) {
		client.addLocation(location);
	}
}
