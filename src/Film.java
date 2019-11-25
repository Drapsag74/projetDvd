import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Film {
	public static float PRIX=5;

	private String titre;
	private Date date;
	private String resume;
	private Image image;
	private int nbDvdDispo;
	private int nbDvdLoue;
	private List<Dvd> dvds;

	public Film(String titre, Date date, String resume, Image image) {
		super();
		this.titre = titre;
		this.date = date;
		this.resume = resume;
		this.image = image;
		this.dvds = new ArrayList<>();
	}
	
	public Dvd getDvdDispo() throws PasDeDvdException{
		if(nbDvdDispo>0) {
			for(Dvd d : dvds){
				if(d.estDispo()) {
					nbDvdDispo--;
					nbDvdLoue++;
					return d;
				}
			}
			throw new PasDeDvdException();
		}else {
			throw new PasDeDvdException();
		}
	}
	public void addDvd() {
		nbDvdDispo++;
		dvds.add(new Dvd(this));
	}
	
	public String toString() {
		return titre;
	}
	
	class PasDeDvdException extends ProjetDvdException{ 
		  public PasDeDvdException(){
		    System.out.println("Aucun dvd dispo§");
		  }  
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public void increment() {
		nbDvdDispo++;
		nbDvdLoue--;
	}
	public void perte(int id) {
		for(int i=0;i<dvds.size();i++) {
			if(dvds.get(i).getId()==id) {
				dvds.remove(i);
				nbDvdLoue--;
			}
		}
	}

}
