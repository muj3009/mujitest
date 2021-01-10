package sboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sboot.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("select u from User u where u.email = ?1")
	User findByEmail(String email);
	

}
