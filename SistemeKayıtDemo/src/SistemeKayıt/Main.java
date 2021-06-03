package SistemeKay�t;


import SistemeKay�t.GmailManager.GmailManager;
import SistemeKay�t.business.abstracts.UserService;
import SistemeKay�t.business.concretes.UserManager;
import SistemeKay�t.core.concretes.GmailManagerAdapter;
import SistemeKay�t.dataAccess.concretes.HibernateUserDao;
import SistemeKay�t.entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(), new GmailManagerAdapter(new GmailManager()));
        User user =new User();
        user.setId(1);
        user.setName("Mine");
        user.setLastName("Yi�iz");
        user.setEmail("mineyigiz@gmail.com");
        user.setPassword("1234567");
        user.setVerify(true);
        userService.register(user);
        userService.login(user);
        userService.loginWithAccount(user);
        userService.registerWithAccount(user);
        
	}

}
