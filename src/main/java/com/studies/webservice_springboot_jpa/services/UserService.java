package com.studies.webservice_springboot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.webservice_springboot_jpa.entities.User;
import com.studies.webservice_springboot_jpa.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findById(Long id){
		Optional<User> user =  userRepo.findById(id);
		return user.get();
	}

	public User insert(User user) {
		return userRepo.save(user);
	}
	
	public void delete(Long id) {
		userRepo.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User entity = userRepo.getOne(id);
		updateData(entity, user);
		return userRepo.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}
}
