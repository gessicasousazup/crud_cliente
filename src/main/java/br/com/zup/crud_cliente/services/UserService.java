package br.com.zup.crud_cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.crud_cliente.models.User;
import br.com.zup.crud_cliente.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		userRepository.save(user);
	}

//    public Iterable<User> showAllUser() {
//        return userRepository.findAll();
//    }

	public long quantityUser() {
		return userRepository.count();
	}

	public User takeUserById(long id) {
		return userRepository.findById(id).get();
	}

	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	// atualizar usuário
	public User updateUser(long id, User update) {
		User test = new User();
		test = userRepository.findById(id).get();

		if (test != null) {
			update.setId(id);
			return userRepository.save(update);
		}
		return null;
	}

}
