package spring.boot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.backend.model.UserModel;
import spring.boot.backend.repos.UserRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	private static final UserModel NullPointerException = null;
	
	@Autowired
	private UserRepo repo;

	// getUsers is used to get the all details from db
	@GetMapping("/backend/api/getusers")
	public List<UserModel> getUsers() {
		return this.repo.findAll();
	}

	// create is used to get the all details from db
	@PostMapping("/backend/api/createuser")
	public UserModel createUser(@RequestBody UserModel UserModel) {
		return repo.save(UserModel);
	}

	// getUserById is used to get user details form user id
	@GetMapping("/backend/api/getUserById/{userId}")
	public ResponseEntity<UserModel> getUserById(@PathVariable int userId) {
		UserModel userModel = repo.findById(userId).orElse(NullPointerException);
		return ResponseEntity.ok(userModel);

	}

	// updateUser is used to update user details by user id
	@PutMapping("/backend/api/updateuser/{id}")
	public ResponseEntity<UserModel> updateUser(@PathVariable(value = "id") int userid,
			@RequestBody UserModel userModel) {
		UserModel userModel1 = repo.findById(userid).orElse(NullPointerException);
		userModel1.setUserName(userModel.getUserName());
		userModel1.setUserMailId(userModel.getUserMailId());
		 repo.save(userModel1);
		return ResponseEntity.ok(userModel1);

	}

	// deleteUser is used to delete user details by user id
	@DeleteMapping("/backend/api/deleteuser/{id}")
	@ResponseBody
	public ResponseEntity<UserModel> deleteUser(@PathVariable(value = "id") int userId) {
		UserModel userModel = repo.findById(userId).orElse(NullPointerException);
		repo.delete(userModel);
		return ResponseEntity.ok(userModel);

	}

}