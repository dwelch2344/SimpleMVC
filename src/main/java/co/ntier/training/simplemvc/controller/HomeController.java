package co.ntier.training.simplemvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.ntier.training.simplemvc.model.SimpleUser;

@Controller
@Transactional
public class HomeController {
	
	@Inject
	private EntityManager em;

	@RequestMapping({"/", "/home"})
	@Transactional
	public String getHome(Model model) {
		SimpleUser user = new SimpleUser("someguy", "email", BCrypt.hashpw("password", BCrypt.gensalt()));
		em.persist(user);
		em.flush();
		List<SimpleUser> users = em.createQuery("From SimpleUser", SimpleUser.class).getResultList();
		model.addAttribute("users", users);
		return "home";
	}
	
	@RequestMapping("/secure/test")
	public String getSecureTest(Model model) {
		return "home";
	}

}
