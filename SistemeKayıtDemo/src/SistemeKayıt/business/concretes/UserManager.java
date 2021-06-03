package SistemeKayýt.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import SistemeKayýt.business.abstracts.UserService;
import SistemeKayýt.core.abstracts.GmailService;
import SistemeKayýt.dataAccess.abstracts.UserDao;
import SistemeKayýt.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private GmailService gmailService;

	public UserManager(UserDao userDao, GmailService gmailService) {
		this.userDao = userDao;
		this.gmailService = gmailService;
	}

	@Override
	public void register(User user) {
		if (user.getName().length() < 2 & user.getLastName().length() > 2) {
			System.out.println("Ad ve Soyad en az iki karakterden oluþmalýdýr");
		}
		if (user.getPassword().length() <= 6) {
			System.out.println("Parola en az 6 karakterden oluþmalýdýr");
		}
		if (user.getEmail() == user.getEmail()) {
			System.out.println("E-Posta daha önce kullanýlmamýþ olmalýdýr");
		}
		final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			System.out.println(user.getEmail() + " : Email, email formatýna uygun deðil!");
		}
		for (User users : userDao.getAll()) {
			if (users.getEmail().equals(user.getEmail())) {
				System.out.println(user.getEmail() + "E-Posta daha önce kullanýlmamýþtýr");
			}
		}

	}

	@Override
	public void login(User user) {
		if (user.isVerify() == true) {
			userDao.login(user);
			System.out.println("Giriþ  baþarýlý.");
		} else {
			System.out.println("Giriþ  baþarýsýz! Email adresi veya pasword hatalý!");
		}

	}

	@Override
	public void confirm(User user) {
		if (user.isVerify() == true) {
			userDao.confirm(user);
			System.out.println("Sayýn" + user.getName() + " " + user.getLastName() + "Email adresiniz doðrulanmýþtýr");
		} else {
			System.out
					.println("Sayýn" + user.getName() + " " + user.getLastName() + "Email adresiniz doðrulanmamýþtýr");
		}

	}

	@Override
	public void registerWithAccount(User user) {
		user.setVerify(true);
		this.gmailService.register(user);

	}

	@Override
	public void loginWithAccount(User user) {
		if (user.isVerify() == true) {
			this.gmailService.login(user);
		}else {
			System.out.println("Sisteme kayýt saðlanmadý");
		}

	}

}
