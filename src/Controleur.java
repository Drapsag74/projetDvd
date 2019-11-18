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
	 *  
	 * @param client
 	 * @param location
	 */
	public void deletLoc(Client client, Location location) {
		client.suppLoc(location);
	}
	
	/**
	 * 
	 * @param client
	 * @param location
	 */
	public void louer(Client client, Location location) {
		client.addLocation(location);
	}
}
