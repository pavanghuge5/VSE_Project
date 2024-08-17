package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository RoleRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int uid) {
        return userRepository.findById(uid);
    }

    //public User saveUser(User user) {
      //  return userRepository.save(user);
    //}
    public User saveUser(User user) {
        Role role = RoleRepository.findById(user.getRole().getRoleId())
                       .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        return userRepository.save(user);
    }
    public void deleteUserById(int uid) {
        userRepository.deleteById(uid);
    }
}