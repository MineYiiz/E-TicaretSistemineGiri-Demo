package SistemeKayıt.core.concretes;

import SistemeKayıt.GmailManager.GmailManager;
import SistemeKayıt.core.abstracts.GmailService;
import SistemeKayıt.entities.concretes.User;

public class GmailManagerAdapter implements GmailService{
	private GmailManager gmailManager;
	public GmailManagerAdapter(GmailManager gmailManager) {
		this.gmailManager = gmailManager;
	}

	@Override
	public void register(User user) {
		GmailManager gmailManager = new GmailManager();
		gmailManager.gmail(user.getName() + " : Gmail hesabınızla sisteme kaydedildiniz.");

	}

	@Override
	public void login(User user) {
		gmailManager.gmail(user.getName() + " : Gmail hesabınızla sisteme giriş yaptı.");
		
	}

}
