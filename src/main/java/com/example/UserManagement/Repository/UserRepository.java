package com.example.UserManagement.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import com.example.UserManagement.Model.User;
import java.lang.String;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByUserLastName(String userlastname, Sort sort);
	List<User> findByUserFirstName(String userfirstname);
	List<User> findByUserFirstNameAndUserLastName(String emailAddress, String lastname);
	List<User> findByUserLastNameOrderByUserFirstNameAsc(String lastname);

}
