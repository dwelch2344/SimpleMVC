package co.ntier.training.simplemvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ntier.training.simplemvc.model.SimpleUser;

@Repository
public interface SimpleUserRepository extends JpaRepository<SimpleUser, Long>{

}
