package SistemeKay�t.core.concretes;

import SistemeKay�t.GmailManager.GmailManager;
import SistemeKay�t.core.abstracts.GmailService;
import SistemeKay�t.entities.concretes.User;

public class GmailManagerAdapter implements GmailService{
	private GmailManager gmailManager;
	public GmailManagerAdapter(GmailManager gmailManager) {
		this.gmailManager = gmailManager;
	}

	@Override
	public void register(User user) {
		GmailManager gmailManager = new GmailManager();
		gmailManager.gmail(user.getName() + " : Gmail hesab�n�zla sisteme kaydedildiniz.");

	}

	@Override
	public void login(User user) {
		gmailManager.gmail(user.getName() + " : Gmail hesab�n�zla sisteme giri� yapt�.");
		
	}

}
