package co.ntier.training.simplemvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.ntier.training.simplemvc.model.SimpleUser;
import co.ntier.training.simplemvc.repo.SimpleUserRepository;

@Controller
@Transactional
public class HomeController {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private SimpleUserRepository repo;

	@RequestMapping({"/", "/home"})
	@Transactional
	public String getHome(Model model) {
		SimpleUser user = new SimpleUser("someguy", "email", BCrypt.hashpw("password", BCrypt.gensalt()));
		user = repo.save(user);
		List<SimpleUser> users = repo.findAll();
		model.addAttribute("users", users);
		return "home";
	}
	
	@RequestMapping("/secure/test")
	public String getSecureTest(Model model) {
		return "home";
	}
	
	public void entityManagerTest(){
		SimpleUser user = new SimpleUser("someguy", "email", BCrypt.hashpw("password", BCrypt.gensalt()));
		em.persist(user);
		em.flush();
		List<SimpleUser> users = em.createQuery("From SimpleUser", SimpleUser.class).getResultList();
		System.out.println(users.size() + " users");
	}

}
