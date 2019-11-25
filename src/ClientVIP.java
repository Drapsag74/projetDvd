

import java.util.ArrayList;
import java.util.List;

public class ClientVIP extends Client {
	private List<Location> locs;
	private float compte;
	public ClientVIP(String nom, String prenom, String mail, String numeroTel, String cbNum) {
		super(nom, prenom, mail, numeroTel, cbNum);
		this.compte=0;
		this.locs=new ArrayList<>();
	}
	
	public void addLocation(Location l) {
		this.locs.add(l);
		
	}
	@Override
	public void suppLoc(Location l) {
		for(int i=0;i<locs.size();i++) {
			if(locs.get(i).equals(l)) {
				locs.remove(i);
			}
		}
		
	}
	
	protected int nbJour() {
		return 3;
	}
	
	public boolean LoctaionPossible() {
		return locs.size()<3;
	}
	
	@Override
	public List<Location> getLocs() {
		return locs;
	}
	
	public void addCompte(float c) {
		this.compte+=c;
	}
	public float getCompte() {
		return this.compte;
	}
	
	public void paye(float c) {
		this.compte-=c;
	}
	@Override
	public void perte(Location l) {
		for(int i=0;i<locs.size();i++) {
			if(locs.get(i).equals(l)) {
				locs.remove(i);
			}
		}
		l.perte();
		
	}
	

}
