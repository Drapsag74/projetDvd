

public class Dvd {
	
	private int id;
	private Film film;
	private boolean estDispo;

	public Dvd(int id, Film film) {
		super();
		this.id = id;
		this.film = film;
		this.estDispo=true;
	}
	
	public boolean estDispo() {
		return estDispo;
	}
	
	public void louer() {
		this.estDispo=false;
	}

	public void rendu() {
		this.estDispo=true;
	}
}
