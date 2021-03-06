package SistemeKayıt;


import SistemeKayıt.GmailManager.GmailManager;
import SistemeKayıt.business.abstracts.UserService;
import SistemeKayıt.business.concretes.UserManager;
import SistemeKayıt.core.concretes.GmailManagerAdapter;
import SistemeKayıt.dataAccess.concretes.HibernateUserDao;
import SistemeKayıt.entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(), new GmailManagerAdapter(new GmailManager()));
        User user =new User();
        user.setId(1);
        user.setName("Mine");
        user.setLastName("Yiğiz");
        user.setEmail("mineyigiz@gmail.com");
        user.setPassword("1234567");
        user.setVerify(true);
        userService.register(user);
        userService.login(user);
        userService.loginWithAccount(user);
        userService.registerWithAccount(user);
        
	}

}
