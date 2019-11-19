import java.util.ArrayList;
import java.util.List;

public class ClientCB extends Client {
	private Location loc;

	public ClientCB(String nom, String prenom, String mail, String numeroTel, String cbNum) {
		super(nom, prenom, mail, numeroTel, cbNum);
		this.loc=null;
	}
	
	@Override
	public void addLocation(Location l) {
		this.loc=l;
	}
	
	@Override
	public void suppLoc(Location l) {
		if(loc.equals(l)) {
			this.loc=null;
		}
	}
	
	protected int nbJour() {
		return 1;
	}
	
	public boolean LoctaionPossible() {
		return loc==null;
	}
	@Override
	public List<Location> getLocs() {
		List<Location> locs=new ArrayList<Location>();
		if(loc!=null) {
			locs.add(loc); 
		}
		return locs;
	}
}
