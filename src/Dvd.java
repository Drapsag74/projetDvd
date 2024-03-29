

public class Dvd {
	private static int nbDvd=0;
	
	private int id;
	private Film film;
	private boolean estDispo;

	public Dvd( Film film) {
		super();
		this.id = nbDvd;
		increment();
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
		this.film.increment();
	}
	
	private void increment() {
		nbDvd++;
	}
	
	public String toString(){
		return film.toString();
	}
	
	public Film getFilm() {
		return this.film;
	}
	
	public void perte() {
		film.perte(id);
	}
	public int getId() {
		return this.id;
	}
}
