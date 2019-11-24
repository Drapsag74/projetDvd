import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tests {
	
	static ArrayList<Film> listFilms;
	
	private static Dvd getDvdTest() {
		Random r = new Random();
		return new Dvd(listFilms.get(r.nextInt(listFilms.size())));
	}
	
	private static void etatCompte(Client c) {
		String nature = (c instanceof ClientVIP) ? "VIP" : "CB";;
		System.out.println("\nNature du compte : " + nature);
		System.out.println("Location actuel :" );
		System.out.println(c.getLocs().size());
		for(int i=0; i < c.getLocs().size(); i++) {
			System.out.println("Location n°"+i+" : "+c.getLocs().get(i));
		}
		System.out.println();
	}
	private static void testLouer(Client c) throws ProjetDvdException{
		Dvd aLouer = getDvdTest();
		System.out.println("Location DVD aléatoire...");
		System.out.println("Film loué : "+aLouer+"\n");
		c.louer(aLouer);
	}

	private static void testRendre(Client c) {
		Scanner s = new Scanner(System.in);
		System.out.println("Index du DVD à rendre ?");
		int aRendre = s.nextInt();
		System.out.println("Rendu...\n");
		c.suppLoc(c.getLocs().get(aRendre));
	}

	private static void testLocationMultiple(Client c, int nbLocation) throws ProjetDvdException {
		System.out.println("Locations de "+nbLocation+" DVDs...");
		for (int i = 0; i < nbLocation; i++) {
			Dvd aLouer = getDvdTest();
			c.louer(aLouer);
		}
	}

	public static void main(String[] args) {
		ArrayList<Client> clients = new ArrayList<Client>();
		listFilms = new ArrayList<Film>();
		String choixTest;
		Scanner sc = new Scanner(System.in);

		clients.add(new ClientCB("CB", "Prenom", "nom.prenom@mail.com", "0123456789","1111222233334444"));
		clients.add(new ClientVIP("VIP", "Prenom", "nom.prenom@mail.com", "0123456789","1111222233334444"));

		for (int i = 0; i < 10; i++) {
			listFilms.add(new Film("film"+i,null,null,null));
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
					clientTest = clients.get(choix);
				}
			}while(clientTest==null);

			do {
				System.out.println("Choix de test :");
				System.out.println("e : Etat du compte");
				System.out.println("l : Test de location");
				System.out.println("r : Test de rendu");
				System.out.println("ml : Test de location multiple");
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

				case "ml":
					System.out.println("Nombre de location à effectuer ? Nombre de location actuelle du client : "+ clientTest.getLocs().size());
					int nbLocation = sc.nextInt();
					if(nbLocation<0) {
						System.out.println("Entrer un nombre de location positif");
						break;
					}
					try {
						testLocationMultiple(clientTest, nbLocation);
					} catch (ProjetDvdException e) {
						e.printStackTrace();
					}
					break;

				case "q":
					System.out.println("Fin de test");
					System.out.println("Changer de client ? [O/n]");
					if(sc.next().equals("n")) {
						return;
					}
					break;
				default:
					System.out.println("Choix invalide");
				}
			}while(!choixTest.equals("q"));
		}
	}
	
}



