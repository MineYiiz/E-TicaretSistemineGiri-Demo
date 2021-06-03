package SistemeKayýt;


import SistemeKayýt.GmailManager.GmailManager;
import SistemeKayýt.business.abstracts.UserService;
import SistemeKayýt.business.concretes.UserManager;
import SistemeKayýt.core.concretes.GmailManagerAdapter;
import SistemeKayýt.dataAccess.concretes.HibernateUserDao;
import SistemeKayýt.entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(), new GmailManagerAdapter(new GmailManager()));
        User user =new User();
        user.setId(1);
        user.setName("Mine");
        user.setLastName("Yiðiz");
        user.setEmail("mineyigiz@gmail.com");
        user.setPassword("1234567");
        user.setVerify(true);
        userService.register(user);
        userService.login(user);
        userService.loginWithAccount(user);
        userService.registerWithAccount(user);
        
	}

}
