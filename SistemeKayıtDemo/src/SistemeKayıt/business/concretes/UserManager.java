package SistemeKay�t.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import SistemeKay�t.business.abstracts.UserService;
import SistemeKay�t.core.abstracts.GmailService;
import SistemeKay�t.dataAccess.abstracts.UserDao;
import SistemeKay�t.entities.concretes.User;

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
			System.out.println("Ad ve Soyad en az iki karakterden olu�mal�d�r");
		}
		if (user.getPassword().length() <= 6) {
			System.out.println("Parola en az 6 karakterden olu�mal�d�r");
		}
		if (user.getEmail() == user.getEmail()) {
			System.out.println("E-Posta daha �nce kullan�lmam�� olmal�d�r");
		}
		final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			System.out.println(user.getEmail() + " : Email, email format�na uygun de�il!");
		}
		for (User users : userDao.getAll()) {
			if (users.getEmail().equals(user.getEmail())) {
				System.out.println(user.getEmail() + "E-Posta daha �nce kullan�lmam��t�r");
			}
		}

	}

	@Override
	public void login(User user) {
		if (user.isVerify() == true) {
			userDao.login(user);
			System.out.println("Giri�  ba�ar�l�.");
		} else {
			System.out.println("Giri�  ba�ar�s�z! Email adresi veya pasword hatal�!");
		}

	}

	@Override
	public void confirm(User user) {
		if (user.isVerify() == true) {
			userDao.confirm(user);
			System.out.println("Say�n" + user.getName() + " " + user.getLastName() + "Email adresiniz do�rulanm��t�r");
		} else {
			System.out
					.println("Say�n" + user.getName() + " " + user.getLastName() + "Email adresiniz do�rulanmam��t�r");
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
			System.out.println("Sisteme kay�t sa�lanmad�");
		}

	}

}
