package sboot.services;


import java.util.List;

import sboot.dto.Person;


/**
 * Defines DAO operations for the person model.
 * @author www.codejava.net
 *
 */

public interface PersonDAO {
	
	public void saveOrUpdate(Person person);
        public void addUserRole(Person person,String role);
	
	public void delete(int personId);
	
	public Person get(int personId);
	
	public List<Person> list();
}
