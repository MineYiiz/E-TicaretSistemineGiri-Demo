package SistemeKayıt.dataAccess.abstracts;

import java.util.List;

import SistemeKayıt.entities.concretes.User;

public interface UserDao {
	void register(User user);
	void login(User user);
	void confirm(User user);
	
	List<User> getAll();

}
