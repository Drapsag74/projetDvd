import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Client {
	private static int nbClient;

	private String nom;
	private String prenom;
	private String mail;
	private String numeroTel;
	private int id;
	private String cbNum;

	public Client(String nom, String prenom, String mail, String numeroTel, String cbNum) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.numeroTel = numeroTel;
		this.id = id;
		incremente();
		this.cbNum = cbNum;
	}
	
	/**
	 * Ajoute un dvd au client 
	 * @param Dvd
	 * Le dvd a louer 
	 */
	public void louer(Dvd d) throws nbLocMax{
		if(LoctaionPossible()) {
			Long millis = System.currentTimeMillis();
		    Date date = new Date(millis);
		    Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(Calendar.DATE, nbJour());
		    date=c.getTime();
			Location l=new Location(date,this,d);
		}else {
			throw new nbLocMax();
		}
		
	}
	
	private static void incremente() {
		nbClient++;
	}
	
	protected abstract int nbJour();
	
	public abstract List<Location> getLocs();
	
	public abstract void addLocation(Location l);
	public abstract void suppLoc(Location l);
	public abstract boolean LoctaionPossible();
	
	
	class nbLocMax extends ProjetDvdException{ 
		  public nbLocMax(){
		    System.out.println("ne peut pas louer plus de dvd");
		  }  
	}
	
	

}
