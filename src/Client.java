
public abstract class Client {

	private String nom;
	private String prenom;
	private String mail;
	private String numeroTel;
	private int id;
	private String cbNum;

	public Client(String nom, String prenom, String mail, String numeroTel, int id, String cbNum) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.numeroTel = numeroTel;
		this.id = id;
		this.cbNum = cbNum;
	}
	
	public abstract void addLocation(Location l);
	public abstract void suppLoc(Location l);

}
