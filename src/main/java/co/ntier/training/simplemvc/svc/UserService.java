package co.ntier.training.simplemvc.svc;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.ntier.training.simplemvc.model.SimpleUser;
import co.ntier.training.simplemvc.repo.SimpleUserRepository;

@Service
@Transactional(propagation=Propagation.MANDATORY)
public class UserService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private SimpleUserRepository repo;
	
	public SimpleUser create(String name, String email, String password){
		SimpleUser user = new SimpleUser(name, email, BCrypt.hashpw(password, BCrypt.gensalt()));
		user = repo.save(user);
		return user;
	}
	
	public List<SimpleUser> findAll() {
		List<SimpleUser> users = repo.findAll();
		return users;
	}
	
	public void simpleUserTest(){
		SimpleUser user = new SimpleUser("someguy", "email", BCrypt.hashpw("password", BCrypt.gensalt()));
		em.persist(user);
		em.flush();
		List<SimpleUser> users = em.createQuery("From SimpleUser", SimpleUser.class).getResultList();
		System.out.println(users.size() + " users");
	}

	
	
}
