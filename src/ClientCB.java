

public class ClientCB extends Client {
	private Location loc;

	public ClientCB(String nom, String prenom, String mail, String numeroTel, int id, String cbNum) {
		super(nom, prenom, mail, numeroTel, id, cbNum);
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

}
