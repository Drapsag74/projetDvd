import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controleur {

	private List<Client> listClients;
	private List<Film> listFilms;
	
	public Controleur() {
		listClients= new ArrayList<>();
		listFilms = new ArrayList<>();
		String choixTest;
		Scanner sc = new Scanner(System.in);

		listClients.add(new ClientCB("CB", "Prenom", "nom.prenom@mail.com", "0123456789","1111222233334444"));
		listClients.add(new ClientVIP("VIP", "Prenom", "nom.prenom@mail.com", "0123456789","1111222233334444"));

		for (int i = 0; i < 10; i++) {
			Film f=new Film("film"+i,null,null,null);
			f.addDvd();
			f.addDvd();
			listFilms.add(f);
		}

		while(true) {
			Client clientTest;
			do {
				System.out.println("Type de client à tester ?");
				System.out.println("0 : CB");
				System.out.println("1 : VIP");
				int choix = sc.nextInt();
				System.out.println(choix);
				if(choix !=0 && choix!=1) {
					System.out.println("Choix  invalide");
					clientTest = null;
				}else {
					clientTest = listClients.get(choix);
				}
			}while(clientTest==null);

			do {
				System.out.println("Choix :");
				System.out.println("e : Etat du compte");
				System.out.println("a : Recharge du compte");
				if(clientTest.LoctaionPossible() && clientTest.getCompte()>0) {
					System.out.println("l : Location");
				}
				if(clientTest.getLocs().size()>0) {
					System.out.println("r : Rendu");
				}
				System.out.println("q : Quitter programme test ou changer de type de client");
				choixTest = sc.next();

				switch (choixTest) {
				case "e":
					etatCompte(clientTest);
					break;

				case "l":
					try {
						testLouer(clientTest);
					} catch (ProjetDvdException e1) {
						e1.printStackTrace();
					}
					break;

				case "r":
					testRendre(clientTest);
					break;

				case "q":
					System.out.println("Fin de test");
					System.out.println("Changer de client ? [O/n]");
					if(sc.next().equals("n")) {
						return;
					}
					break;
					
				case "a":
					System.out.println("Somme");
					float choix = sc.nextFloat();
					clientTest.addCompte(choix);
					System.out.println("Ajout de "+choix + "€ sur votre compte");
					break;
				default:
					System.out.println("Choix invalide");
				}
			}while(!choixTest.equals("q"));
		}
	}
	
	/**
	 * Re�oit en paramettre un client et une location. Supprime la location du client
	 * @param client
	 * Un objet Client
	 * @param location
	 * Un objet Location
	 */
	public void deletLoc(Client client, Location location) {
		client.suppLoc(location);
	}
	
	/**
	 * Re�oit en paramettre un client et un location. Ajoute la location au client
	 * @param client
	 * @param location
	 */
	public void louer(Client client, Location location) {
		client.addLocation(location);
	}
	
	public Film getFilm(int i) {
		return listFilms.get(i);
	}
	public int getNbFilm() {
		return listFilms.size();
	}
	
	public void init() {
		listClients.add(new ClientVIP("client","1","Client.1@qsdgqsg.fr","0625352624","6549852398749875"));
		listClients.add(new ClientVIP("client","2","Client.2@qsdgqsg.fr","0658966352","7856469734596453"));
		listClients.add(new ClientVIP("client","3","Client.3@qsdgqsg.fr","0685741225","6543216549876546"));
		listFilms.add(new Film("film1",null,null,null));
		listFilms.add(new Film("film2",null,null,null));
		listFilms.add(new Film("film3",null,null,null));
		for(Film f : listFilms) {
			for(int i=0;i>3;i++) {
				f.addDvd();
			}
		}
	}
	
	public static void main(String[] args) {
		Controleur c = new Controleur();
	}
	
	private void etatCompte(Client c) {
		String nature = (c instanceof ClientVIP) ? "VIP" : "CB";;
		System.out.println("\nNature du compte : " + nature);
		System.out.println("Location actuel :" );
		System.out.println(c.getLocs().size());
		for(int i=0; i < c.getLocs().size(); i++) {
			System.out.println("Location n°"+i+" : "+c.getLocs().get(i));
		}
		System.out.println("Compte : "+c.getCompte());
		System.out.println();
	}
	
	private void testLouer(Client c) throws ProjetDvdException{
		if(c.LoctaionPossible() && c.getCompte()>0) {
			Scanner sc = new Scanner(System.in);
			for(int i=0;i<getNbFilm();i++) {
				System.out.println(i+": "+getFilm(i).getTitre());
			}
			int choixTest = sc.nextInt();
			Dvd aLouer = getFilm(choixTest).getDvdDispo();
			c.louer(aLouer);
		}
	}
	
	private void testRendre(Client c) {
		int i=0;
		for(Location l:c.getLocs()) {
			System.out.println(i+": "+l.getFilm().getTitre());
			i++;
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Index du DVD à rendre ou -1 pour une perte?");
		int aRendre = s.nextInt();
		System.out.println(aRendre);
		if(aRendre!=-1) {
			System.out.println("Rendu...\n");
			c.suppLoc(c.getLocs().get(aRendre));
		}else {
			System.out.println("Index du DVD perdu\n");
			aRendre = s.nextInt();
			c.perte(c.getLocs().get(aRendre));
		}
		
	}
	
	
}
