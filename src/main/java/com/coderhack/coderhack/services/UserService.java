package com.coderhack.coderhack.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderhack.coderhack.entity.User;
import com.coderhack.coderhack.exception.InvalidScoreException;
import com.coderhack.coderhack.exception.UserNotFoundException;
import com.coderhack.coderhack.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User>getAllUsers(){
		return userRepository.findAll();
	}
	@GetMapping("/{userId}")
	public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }
	@PostMapping
	public User registerUser(@Validated User user) {
        user.setScore(0);
        user.setBadges(new HashSet<>());
        return userRepository.save(user);
    }
	@DeleteMapping("/{userId}")
	public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

	
	
	private Set<String> calculateBadges(int score) {
        Set<String> badges = new HashSet<>();
        if (score < 0 || score > 100) {
        	throw new InvalidScoreException("Score must be between 0 and 100");
        }if (score >= 1 && score < 30) {
            badges.add("Code Ninja");
        } else if (score >= 30 && score < 60) {
            badges.add("Code Champ");
        } else if (score >= 60 && score <= 100) {
            badges.add("Code Master");
        }
        return badges;
    }
	

	@PutMapping("/{userId}")
    public User updateScore(@PathVariable String userId, @RequestParam  int score) {
        User user = getUserById(userId);
        user.setScore(score);
        user.setBadges(calculateBadges(score));
        return userRepository.save(user);
    }
	

}

