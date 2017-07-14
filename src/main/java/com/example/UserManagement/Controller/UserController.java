package com.example.UserManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.UserManagement.Model.User;
import com.example.UserManagement.Repository.UserRepository;


@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public String process(){
		repository.save(new  User("Priyanka", "Pakhre", "9029062708", "pri@ge.com", "Controller","incharge of site",3));       
		repository.save(new User("Adam", "Johnson","1234567890","abc@ge.com","Admin","ajfh",3));
		repository.save(new User("Kim", "Smith","1234567890","abc@ge.com","Admin","fghxf",5));
		repository.save(new User("David", "Williams","1234567890","abc@ge.com","user","",7));
		repository.save(new User("Peter", "Davis","1234567890","abc@ge.com","Commander","",1));
		repository.save(new User("Jack", "Smith","1234567890","abc@ge.com","Admin","t",10));
		return "Done";
	}
	
	@RequestMapping(value = "/saveAUser",method = RequestMethod.POST)
    public String saveUser(@RequestBody User userdata){
		if(userdata!= null)
		{
			repository.save(userdata);  
			return "User Added";
		}
		else
			return "Enter valid User Data";
			
    }
	
	//Yet to be tested
	@RequestMapping(value = "/update/{sso-id}", method = RequestMethod.PUT)
    public String saveOrUpdateUser(@PathVariable("sso-id")long ssoId, @RequestBody User userdata){
		String result="";
		if (repository.exists(ssoId))
		{
			userdata.setSsoid(ssoId);
			result = "User Exist so Updating..";
		}
		repository.save(userdata); 
		result = result+ "User added/updated";
		return result;
    }
	
	
	@RequestMapping(value="/findallUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		for(User user : repository.findAll()){
			users.add(user);
		}
		return users;
	}
	
	
	@RequestMapping(value = "findUserbyId/{sso-id}",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable("sso-id")long ssoId){
		if(ssoId > 0)
        {
			User u = repository.findOne(ssoId);
			return u;
        }
        return null;
    }
	
	@RequestMapping(value="deleteUser/{sso-id}",method=RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable("sso-id")long ssoId){
      
        if(ssoId > 0)
        {
        	if(repository.findOne(ssoId) != null)
        	{
        		repository.delete(ssoId);
        		return "User  Deleted";
        	}
        	else
        	{
        		return "User Doesnt Exist";
        	}
        }
        else
        	return "Enter valid Id";
    }
	
	
	@RequestMapping(value = "/findbylastname/{user-last-name}",method = RequestMethod.GET)
	@ResponseBody
	public List<User> fetchDataByLastName(@PathVariable("user-last-name")String lastName){
		if(lastName != null)
	    {
			List<User> users;

			
			users = repository.findByUserLastName(lastName,new Sort("userFirstName"));
			return users;
	    }
		 return null;
	}
	
	@RequestMapping(value = "/findbyfirstname/{user-first-name}",method = RequestMethod.GET)
	@ResponseBody
	public List<User> fetchDataByFirstName(@PathVariable("user-first-name")String firstName){
		if(firstName != null)
	    {
			List<User> users;
			users = repository.findByUserFirstName(firstName);
			return users;
	    }
		 return null;
	}
	
	@RequestMapping(value = "/findbylastnameOrdered/{user-last-name}",method = RequestMethod.GET)
	@ResponseBody
	public List<User> fetchByLastnameOrderByFirstnameAsc (@PathVariable("user-last-name")String lastname){
		if(lastname != null)
	    {
			List<User> users;
			users = repository.findByUserLastNameOrderByUserFirstNameAsc(lastname);
			return users;
	    }
		 return null;
	}
	
	
	
	@RequestMapping(value = "/findbyfirstnameandlastname",method = RequestMethod.GET)
	@ResponseBody
	public List<User> fetchDataByFirstName(@RequestParam("user-first-name") String firstname,
											@RequestParam("user-last-name") String lastname){
		
		if(lastname != null && firstname!= null )
	    {
			List<User> users;
			users = repository.findByUserFirstNameAndUserLastName(firstname, lastname);
			return users;
	    }
		 return null;
	}
	

	
}
