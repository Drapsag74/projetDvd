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
	 * Re�oit en paramettre un client et une location. Supprime la location du client
	 * @param client
	 * Un objet Client
	 * @param location
	 * Un objet Location
	 */
	public void deletLoc(Client client, Location location) {
		client.suppLoc(location);
	}
	
	/**
	 * Re�oit en paramettre un client et un location. Ajoute la location au client
	 * @param client
	 * @param location
	 */
	public void louer(Client client, Location location) {
		client.addLocation(location);
	}
	
	public void init() {
		listClients.add(new ClientVIP("client","1","Client.1@qsdgqsg.fr","0625352624","6549852398749875"));
		listClients.add(new ClientVIP("client","2","Client.2@qsdgqsg.fr","0658966352","7856469734596453"));
		listClients.add(new ClientVIP("client","3","Client.3@qsdgqsg.fr","0685741225","6543216549876546"));
		listFilms.add(new Film("film1",null,null,null));
		listFilms.add(new Film("film2",null,null,null));
		listFilms.add(new Film("film3",null,null,null));
	}
	
	public static void main(String[] args) {
        Controleur c = new Controleur();
    }
}
