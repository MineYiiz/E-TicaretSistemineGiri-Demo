package SistemeKayıt.core.abstracts;

import SistemeKayıt.entities.concretes.User;

public interface GmailService {
	void register(User user);
	void login(User user); 

}
