import java.util.ArrayList;
import java.util.List;


public class Controleur {

	/**
	 *  
	 * @param client
 	 * @param location
	 */
	public void deletLoc(Client client, Location location) {

	}
	
	/**
	 * 
	 * @param film
	 * @param listClientVips
	 * @param lisClientCBs
	 * @return
	 */
	public List<Dvd> getDVDDispo(Film film, List<ClientVIP> listClientVips, List<ClientCB> lisClientCBs) {
		List<Dvd> listDvdDispo = new ArrayList<>();
		listDvdDispo.addAll(film.getDvds());
		for(ClientVIP client:listClientVips) {
			listClientVips.remove(client.getLocation());
		}
		for(ClientCB client:lisClientCBs) {
			listClientVips.remove(client.getLocation());
		}
		return listDvdDispo;
	}
	
	/**
	 * 
	 * @param client
	 * @param location
	 */
	public void louer(Client client, Location location) {
		if(client instanceof ClientVIP) {
			
		}
		else if(client instanceof ClientCB) {
			
		}
		client.addLocation(location);
	}
}
