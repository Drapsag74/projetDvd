public class Tests {
    //Test 1 : Louer un DVD
    Controleur c = new Controleur();
    
	Client clientCB = new ClientCB("CB", "Prenom", "nom.prenom@mail.com", "0123456789", 01, "1111222233334444");
    Client clientVIP = new ClientVIP("VIP", "Prenom", "nom.prenom@mail.com", "0123456789", 01, "1111222233334444");
    
    controleur.louer(clientCB, c.getFilm());
}
