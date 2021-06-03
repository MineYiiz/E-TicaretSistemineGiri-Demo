package SistemeKayýt.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import SistemeKayýt.dataAccess.abstracts.UserDao;
import SistemeKayýt.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	List<User> users= new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println(user.getName() + " : Adlý kiþi sisteme kaydedildi.");
		users.add(user);
	}

	@Override
	public void login(User user) {
		System.out.println(user.getName() + " : Adlý kiþi sisteme giriþ yaptý.");
		
	}

	@Override
	public void confirm(User user) {
		System.out.println(user.getEmail() + " : Email adresiniz onaylandý");
		user.setVerify(true);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}

}
