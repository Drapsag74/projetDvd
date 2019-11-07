

import java.util.ArrayList;
import java.util.List;

public class ClientVIP extends Client {
	private List<Location> locs;
	public ClientVIP(String nom, String prenom, String mail, String numeroTel, int id, String cbNum) {
		super(nom, prenom, mail, numeroTel, id, cbNum);
		this.locs=new ArrayList<>();
	}
	
	public void addLocation(Location l) {
		this.locs.add(l);
		
	}
	@Override
	public void suppLoc(Location l) {
		for(int i=0;i<locs.size();i++) {
			if(locs.equals(l)) {
				locs.remove(i);
			}
		}
		
	}

}
