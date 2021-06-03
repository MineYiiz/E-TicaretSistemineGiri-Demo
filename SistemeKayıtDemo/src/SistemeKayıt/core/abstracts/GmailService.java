package SistemeKayýt.core.abstracts;

import SistemeKayýt.entities.concretes.User;

public interface GmailService {
	void register(User user);
	void login(User user); 

}
