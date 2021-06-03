package SistemeKay�t.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import SistemeKay�t.dataAccess.abstracts.UserDao;
import SistemeKay�t.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	List<User> users= new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println(user.getName() + " : Adl� ki�i sisteme kaydedildi.");
		users.add(user);
	}

	@Override
	public void login(User user) {
		System.out.println(user.getName() + " : Adl� ki�i sisteme giri� yapt�.");
		
	}

	@Override
	public void confirm(User user) {
		System.out.println(user.getEmail() + " : Email adresiniz onayland�");
		user.setVerify(true);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}

}
