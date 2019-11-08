public class Tests {
	//Test 1 : Louer un DVD
	static Controleur controleur;

	
	private static void etatCompte(Client c) {
		String nature = (c instanceof ClientVIP) ? "VIP" : "CB";;
		System.out.println("Nature du compte : " + nature);
		System.out.println("Nombre de location actuel :" );
	}
	
	private static void testLouer(Client c) { //Test de location
		etatCompte(c);
		System.out.println("Location...");
		//traitement...
		etatCompte(c);
	}

	private static void testRendre(Client c) {
		etatCompte(c);
		System.out.println("Rendu...");
		//traitement...
		etatCompte(c);
	}

	private static void testLouerMultiple(Client c, int nbLocation) {
		etatCompte(c);
		System.out.println("Locations...");
		//traitement...
		etatCompte(c);
	}

	public static void main(String[] args) {
		controleur = new Controleur();
		Client clientCB = new ClientCB("CB", "Prenom", "nom.prenom@mail.com", "0123456789", 01, "1111222233334444");
		Client clientVIP = new ClientVIP("VIP", "Prenom", "nom.prenom@mail.com", "0123456789", 01, "1111222233334444");

		testLouer(clientVIP);
	}
}
